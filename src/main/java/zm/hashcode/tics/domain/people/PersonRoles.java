/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public final class PersonRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    private String roleName;

    private PersonRoles() {
    }

    private PersonRoles(Builder builder) {
        roleName = builder.roleName;
    }

    public static class Builder {

        private final String roleName;

        public Builder(String val) {
            this.roleName = val;
        }

        public PersonRoles build() {
            return new PersonRoles(this);
        }
    }

    public String getRoleName() {
        return roleName;
    }
}
