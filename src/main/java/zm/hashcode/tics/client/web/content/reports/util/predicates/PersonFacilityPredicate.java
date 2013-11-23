/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PersonFacilityPredicate implements Predicate<Person> {

    private final String facilityId;

    public PersonFacilityPredicate(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public boolean apply(Person person) {
        return facilityId.equalsIgnoreCase(getFacilityId(person.getFacility()));

    }

    private String getFacilityId(Facility facility) {
        if (facility != null) {
            return facility.getId();
        }
        return null;
    }
}
