/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.users;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.demographics.RolesList;

/**
 *
 * @author boniface
 */

public final class Roles implements Serializable {
   @DBRef
   private RolesList rolesList;

    private Roles() {
    }

    private Roles(Builder builder) {
        rolesList= builder.rolesList;
    }
   
   
   public static class Builder{
        private final RolesList rolesList;

        public Builder(RolesList rolesList) {
            this.rolesList = rolesList;
        }
        public Roles build(){
            return new Roles(this);
        }
   }
   
}
