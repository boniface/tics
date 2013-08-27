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
public class ProvincePredicate implements Predicate<Location> {

    @Override
    public boolean apply(Location location) {
        if (LocationEnumType.PROVINCE.name().equalsIgnoreCase(getLocationName(location))) {
            return true;
        }
        return false;
    }

    private String getLocationName(Location location) {
        if (location != null) {
            return getLocationType(location.getLocationType());
        }
        return null;

    }

    private String getLocationType(LocationType locationType) {
        if (locationType != null) {
            return locationType.getName();
        }
        return null;
    }
}
