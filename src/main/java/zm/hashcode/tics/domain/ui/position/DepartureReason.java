/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.position;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class DepartureReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String reasonName;
    private String description;

    private DepartureReason() {
    }

    private DepartureReason(Builder builder) {
        id = builder.id;
        reasonName = builder.reasonName;
        description = builder.description;
    }

    public static class Builder {

        private String id;
        private final String reasonName;
        private String description;

        public Builder(String val) {
            this.reasonName = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder description(String value) {
            description = value;
            return this;
        }

        public DepartureReason build() {
            return new DepartureReason(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getReasonName() {
        return reasonName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final DepartureReason other = (DepartureReason) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DepartureReason{" + "id=" + id + '}';
    }
}