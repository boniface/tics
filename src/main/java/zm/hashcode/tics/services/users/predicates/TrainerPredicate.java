/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.users.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class TrainerPredicate implements Predicate<User> {

    Role role = UserFacade.getRoleService().findByRolename(RolesEnum.ROLE_TRAINER.name());

    @Override
    public boolean apply(User user) {

        if (user.getRoles().contains(role)) {
            return true;
        }
        return false;
    }
}
