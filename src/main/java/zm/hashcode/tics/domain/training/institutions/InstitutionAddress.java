/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.institutions;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author boniface
 */
public class InstitutionAddress implements Serializable {

    private LocationAddress address;
    @DBRef
    private Location city;

    public LocationAddress getAddress() {
        return address;
    }

    public void setAddress(LocationAddress address) {
        this.address = address;
    }

    public Location getCity() {
        return city;
    }

    public void setCity(Location city) {
        this.city = city;
    }
}
