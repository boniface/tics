/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.predicates;

import zm.hashcode.tics.services.ui.location.predicates.*;
import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.people.PersonIdentities;

/**
 *
 * @author boniface
 */
public class IdentityPredicate implements Predicate<PersonIdentities> {

    @Override
    public boolean apply(PersonIdentities personIdentities) {
        if (LocationEnumType.CITY.name().equalsIgnoreCase(getIdentity(personIdentities))) {
            return true;
        }
        return false;
    }

    private String getIdentity(PersonIdentities personIdentities) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
