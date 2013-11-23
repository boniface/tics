/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author boniface
 */
public class LocationTypePredicate implements Predicate<Location> {

    private final String locationTypeId;

    public LocationTypePredicate(String locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    @Override
    public boolean apply(Location location) {
        if (locationTypeId.equalsIgnoreCase(getLocationTypeId(location))) {
            return true;
        }
        return false;
    }

    private String getLocationTypeId(Location location) {
        if (location != null) {
            return getTypeId(location.getLocationType());
        }
        return null;
    }

    private String getTypeId(LocationType locationType) {
        if (locationType != null) {
            return locationType.getId();
        }
        return null;
    }
}
