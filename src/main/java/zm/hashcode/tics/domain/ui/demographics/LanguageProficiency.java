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
 * @author stud
 */
@Document
public final class LanguageProficiency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String proficiency;

   private LanguageProficiency() {
    }

    private LanguageProficiency(Builder builder) {
        id = builder.id;
        proficiency = builder.proficiency;
    }

    public static class Builder {

        private String id;
        private final String proficiency;

        public Builder(String val) {
            this.proficiency = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public LanguageProficiency build() {
            return new LanguageProficiency(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getProficiency() {
        return proficiency;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final LanguageProficiency other = (LanguageProficiency) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LanguageProficiency{" + "proficiency=" + proficiency + '}';
    }
    
    
}
