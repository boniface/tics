/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.location;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NotNull
    private String name;

    private Contact() {
    }

    private Contact(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static class Builder {

        private String id;
        private final String name;

        public Builder(String val) {
            this.name = val;
        }

        public Contact.Builder id(String value) {
            id = value;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ContactList{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
