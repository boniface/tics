/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.users;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
@Document
public final class Users implements Serializable {

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String passwd;
    private String firstname;
    private String lastname;
    private String middlename;
    private boolean enabled;
    private List<Roles> roles;
    @DBRef
    private Location jusridication;

    private Users() {
    }

    private Users(Builder builder) {
        id = builder.id;
        email = builder.email;
        passwd = builder.passwd;
        firstname = builder.firstname;
        lastname = builder.lastname;
        middlename = builder.middlename;
        enabled = builder.enabled;
        roles = builder.roles;
        jusridication = builder.jusridication;

    }

    public static class Builder {

        @Indexed(unique = true)
        private final String email;
        private final Location jusridication;
        //optional 
        private String id;
        private String passwd;
        private String firstname;
        private String lastname;
        private String middlename;
        private boolean enabled;
        
        private List<Roles> roles;
//        //        return ImmutableList.copyOf(roles);

        public Builder(String email,Location val) {
            this.email = email;
            this.jusridication=val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder passwd(String value) {
            passwd = value;
            return this;
        }

        public Builder firstname(String value) {
            firstname = value;
            return this;
        }

        public Builder lastname(String value) {
            lastname = value;
            return this;
        }

        public Builder middlename(String value) {
            middlename = value;
            return this;
        }

        public Builder roles(List<Roles> value) {
            roles = value;
            return this;
        }

        public Builder enable(boolean value) {
            enabled = value;
            return this;
        }

        public Users build() {
            return new Users(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.model.users.Users[id=" + email + "]";
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Roles> getRoles() {
        return ImmutableList.copyOf(roles);
    }

    public Location getJusridication() {
        return jusridication;
    }
    
}
// Collection<ScheduledCourse> scheduledCourses = Collections2.filter(sc, new InstitutionScheduledCourse());
//        return ImmutableList.copyOf(scheduledCourses);