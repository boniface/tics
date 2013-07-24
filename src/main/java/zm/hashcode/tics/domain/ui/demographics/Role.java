/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.demographics;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author boniface
 */

@Document
public class Role implements Serializable {

    @Id
    private String id;
    @NotNull
    @Indexed
    private String rolename;
    private String description;

    
    private  Role() {
    }

    private Role(Builder builder) {
        id=builder.id;
        rolename=builder.rolename;
        description= builder.description;
    }

    public String getId() {
        return id;
    }

    public String getRolename() {
        return rolename;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Role other = (Role) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolesList{" + "rolename=" + rolename + '}';
    }
    
    

    public static class Builder {

        private final String rolename;
        private String id;
        private String description;

        public Builder(String rolename) {
            this.rolename = rolename;
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }
        
        public Role build(){
            return new Role(this);
        }
        
        

    }
}
