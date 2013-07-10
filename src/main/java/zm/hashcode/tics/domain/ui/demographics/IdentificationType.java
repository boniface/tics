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
public final class IdentificationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String idvalue;
    private String description;

    private IdentificationType() {
    }

    private IdentificationType(Builder builder) {
        id = builder.id;
        idvalue = builder.idvalue;
        description = builder.description;
    }

    public static class Builder {

        private String id;
        private final String idvalue;
        private String description;

        public Builder(String val) {
            this.idvalue = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder description(String value) {
            description = value;
            return this;
        }

        public IdentificationType build() {
            return new IdentificationType(this);
        } 
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final IdentificationType other = (IdentificationType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdentificationType{" + "idvalue=" + idvalue + '}';
    }

    public String getId() {
        return id;
    }

    public String getIdvalue() {
        return idvalue;
    }

    public String getDescription() {
        return description;
    }
    
    
}
