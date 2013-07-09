/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Mentees implements Serializable {

    private String id;
    @DBRef
    private Person mentee;

    private Mentees() {
    }

    private Mentees(Builder builder) {
        id = builder.id;
        mentee = builder.mentee;
       
    }

    public static class Builder {

        private String id = null;
        private final Person mentee;

        public Builder(Person val) {
            this.mentee = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Mentees build() {
            return new Mentees(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Mentees other = (Mentees) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public Person getMentee() {
        return mentee;
    }
    
}
