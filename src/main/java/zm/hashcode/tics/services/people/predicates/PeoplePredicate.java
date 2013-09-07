/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PeoplePredicate implements Predicate<Person> {

    GetUserCredentials creds = new GetUserCredentials();

    @Override
    public boolean apply(Person person) {
        if (creds.getLoggedInUser().getJusridication().contains(person.getFacility())) {
            return true;
        }
        return false;
    }
}
