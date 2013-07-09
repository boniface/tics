/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 *
 * @author boniface
 */
public final class Identities implements Serializable {

    private String idType;
    @Indexed(unique = true)
    private String idValue;

    private Identities() {
    }

    private Identities(Builder builder) {
        idValue = builder.idValue;
        idType = builder.idType;
    }

    public static class Builder {

        private final String idType;
        private String idValue;

        public Builder(String val) {
            this.idType = val;
        }

        public Builder idValue(String value) {
            idValue = value;
            return this;
        }

        public Identities build() {
            return new Identities(this);
        }
    }

    public String getIdType() {
        return idType;
    }

    public String getIdValue() {
        return idValue;
    }
    
}
