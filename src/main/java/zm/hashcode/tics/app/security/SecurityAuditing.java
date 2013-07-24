/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.security;

import org.springframework.data.domain.AuditorAware;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class SecurityAuditing implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        User user = new GetUserCredentials().getLoggedInUser();
        return user.getFirstname()+ "  " + user.getLastname()+ " with email " + user.getEmail();
    }
}
