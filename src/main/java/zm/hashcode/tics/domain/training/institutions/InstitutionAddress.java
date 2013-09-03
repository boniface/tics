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

    private InstitutionAddress() {
    }

    private InstitutionAddress(Builder builder) {
        address = builder.address;
        city = builder.city;
    }

    public static class Builder {

        private LocationAddress address;
        private Location city;

        public Builder(LocationAddress val) {
            this.address = val;
        }

        public Builder city(Location value) {
            city = value;
            return this;
        }

        public InstitutionAddress build() {
            return new InstitutionAddress(this);
        }
    }

    public LocationAddress getAddress() {
        return address;
    }

    public Location getCity() {
        return city;
    }
}
