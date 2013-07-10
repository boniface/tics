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
public class Language implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;


    private Language() {
    }

    private Language(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static class Builder {

        private String id;
       private final String name;

        public Builder(String val) {
            this.name = val;
        }

        public Language.Builder id(String value) {
            id = value;
            return this;
        }

        public Language build() {
            return new Language(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Language other = (Language) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Language{" + "id=" + id + ", name=" + name + '}';
    }
    
}
