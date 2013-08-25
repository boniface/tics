/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.competencies;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Competency {

    @Id
    private String id;
    private String name;
    @DBRef
    private CompetencyType type;
    private String notes;

    private Competency() {
    }

    private Competency(Builder builder) {
        id = builder.id;
        name = builder.name;
        type = builder.type;
        notes = builder.notes;

    }

    public static class Builder {

        private String id;
        private final String name;
        private CompetencyType type;
        private String notes;

        public Builder(String val) {
            this.name = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder notes(String value) {
            notes = value;
            return this;
        }

        public Builder type(CompetencyType value) {
            type = value;
            return this;
        }

        public Competency build() {
            return new Competency(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CompetencyType getType() {
        return type;
    }

    public String getNotes() {
        return notes;
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
        final Competency other = (Competency) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Competency{" + "name=" + name + '}';
    }
}
