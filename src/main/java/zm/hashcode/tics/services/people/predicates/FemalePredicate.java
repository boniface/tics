/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class FemalePredicate implements Predicate<Person> {

    @Override
    public boolean apply(Person person) {
        if ("FEMALE".equalsIgnoreCase(person.getDemography().getGender().getGender())) {
            return true;
        }
        return false;
    }
}
