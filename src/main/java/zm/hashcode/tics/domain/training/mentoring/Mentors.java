/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.mentoring;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public class Mentors implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private String qualification;

    private Mentors() {
    }

    private Mentors(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        title = builder.title;
        qualification = builder.qualification;
    }

    public static class Builder {

        private String id;
        private String firstName;
        private String lastName;
        private String title;
        private String qualification;

        public Builder(String val) {
            this.title = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder firstName(String value) {
            firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            lastName = value;
            return this;
        }

        public Builder qualification(String value) {
            qualification = value;
            return this;
        }

        public Mentors build() {
            return new Mentors(this);
        }
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
        final Mentors other = (Mentors) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mentors{" + "id=" + id + ", title=" + title + '}';
    }

    public String getId() {
        return id;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
}
