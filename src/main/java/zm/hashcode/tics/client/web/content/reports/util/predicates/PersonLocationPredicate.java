/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
public class PersonLocationPredicate implements Predicate<Person> {

    private final String locationId;

    public PersonLocationPredicate(String locationId) {

        this.locationId = locationId;
    }

    @Override
    public boolean apply(Person person) {
        Location location = LocationFacade.getLocationService().find(locationId);
        Location personLocation = person.getFacility().getCity();
        return locationsEqual(location, personLocation);
    }

    private boolean locationsEqual(Location location, Location personLocation) {
        boolean exists = false;
        if (location.equals(personLocation)) {
            exists = true;
        } else {
            if (personLocation.getParent() != null) {
                exists = locationsEqual(location, personLocation.getParent());
            }
        }
        return exists;
    }
}
