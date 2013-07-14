/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class RegistrationBody implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @NotNull
    private String name;
    private String description;
    private String coreActivity;
    private String active;
    @NotNull
    private Date startDate;

    private RegistrationBody() {
    }

    private RegistrationBody(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        coreActivity= builder.coreActivity;
        active=builder.active;
        startDate= builder.startDate;
    }
    public static class Builder {

        private String id;
        private final String name;
        private String description;
        private String coreActivity;
        private String active;
        private Date startDate;

        public Builder(String val) {
            this.name = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder description(String value) {
            description = value;
            return this;
        }

        public Builder coreActivity(String value) {
            coreActivity = value;
            return this;
        }

        public Builder active(String value) {
            active = value;
            return this;
        }

        public Builder startDate(Date value) {
            startDate = value;
            return this;
        }

        public RegistrationBody build() {
            return new RegistrationBody(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoreActivity() {
        return coreActivity;
    }

    public String getActive() {
        return active;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final RegistrationBody other = (RegistrationBody) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistrationBody{" + "name=" + name + '}';
    }
    
}
