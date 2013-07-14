/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.ui.demographics;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class MaritalStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String statusName;


  private MaritalStatus() {
    }

    private MaritalStatus(Builder builder) {
        id = builder.id;
        statusName = builder.statusName;
    }

    public static class Builder {

        private String id;
        private final String statusName;

        public Builder(String val) {
            this.statusName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public MaritalStatus build() {
            return new MaritalStatus(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MaritalStatus other = (MaritalStatus) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaritalStatusList{" + "statusName=" + statusName + '}';
    }
    
    
}
