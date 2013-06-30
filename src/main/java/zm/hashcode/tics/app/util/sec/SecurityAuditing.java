/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.util.sec;

import org.springframework.data.domain.AuditorAware;
import zm.hashcode.hashwork.domain.people.Person;

/**
 *
 * @author boniface
 */
public class SecurityAuditing implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        Person p = new GetUserCredentials().getLoggedInUser();
        return p.getFirstName() + "  " + p.getLastName() + " with email " + p.getEmailAddress();
    }
}
