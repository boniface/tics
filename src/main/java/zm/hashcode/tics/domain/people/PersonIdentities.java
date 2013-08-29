/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;

/**
 *
 * @author boniface
 */
public final class PersonIdentities implements Serializable {

    @Id
    private String id;
    @DBRef
    private IdentificationType idType;
    @Indexed(unique = true)
    private String idValue;

    private PersonIdentities() {
    }

    private PersonIdentities(Builder builder) {
        idValue = builder.idValue;
        idType = builder.idType;
    }

    public static class Builder {

        private IdentificationType idType;
        private String idValue;

        public Builder(IdentificationType val) {
            this.idType = val;
        }

        public Builder idValue(String value) {
            idValue = value;
            return this;
        }

        public PersonIdentities build() {
            return new PersonIdentities(this);
        }
    }

    public IdentificationType getIdType() {
        return idType;
    }

    public String getIdValue() {
        return idValue;
    }
}
