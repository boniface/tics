/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.util;

import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.client.web.content.users.models.UserBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class UserUtil {

    public UserBean getBean(User user) {
        UserBean bean = new UserBean();
        bean.setEmail(user.getEmail());
        bean.setEnabled(user.isEnabled());
        bean.setFirstname(user.getFirstname());
        bean.setId(user.getId());
        bean.setJusridicationIds(getFacilityIds(user.getJusridication()));
        bean.setLastname(user.getLastname());
        bean.setMiddlename(user.getMiddlename());
        bean.setPasswd(user.getPasswd());
        bean.setRoleIds(getRolesIds(user.getRoles()));
        return bean;
    }

    private Set<String> getFacilityIds(Set<Facility> jusridication) {
        Set<String> ids = new HashSet<>();
        for (Facility facility : jusridication) {
            ids.add(facility.getId());
        }
        return ids;

    }

    private Set<String> getRolesIds(Set<Role> roles) {
        Set<String> ids = new HashSet<>();
        for (Role role : roles) {

            ids.add(role.getId());
        }
        return ids;
    }
}
