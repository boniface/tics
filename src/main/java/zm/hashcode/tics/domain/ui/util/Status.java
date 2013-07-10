/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.util;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String statusType;
    private String statusValue;

    private Status() {
    }

    private Status(Builder builder) {
        id = builder.id;
        statusType = builder.statusType;
        statusValue = builder.statusValue;
    }

    public static class Builder {

        private String id;
        private String statusValue;
        private final String statusType;

        public Builder(String val) {
            this.statusType = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Status build() {
            return new Status(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getStatusType() {
        return statusType;
    }

    public String getStatusValue() {
        return statusValue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Status other = (Status) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Status{" + "id=" + id + ", statusValue=" + statusValue + '}';
    }
}