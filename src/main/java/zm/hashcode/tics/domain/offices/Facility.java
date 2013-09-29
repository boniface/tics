/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.offices;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author boniface
 */
@Document
public class Facility implements Serializable, Comparable<Facility> {

    @Id
    private String id;
    private String facilityName;
    private String latitude;
    private String longititude;
    @DBRef
    private FacilityType facilityType;
    @DBRef
    private Location city;
    private LocationAddress address;
    @DBRef
    private List<Position> positions;
    private List<FacilityMentors> facilityMentors;
    @DBRef
    private FacilityGrouping facilityGrouping;

    private Facility() {
    }

    private Facility(Builder builder) {
        id = builder.id;
        facilityName = builder.facilityName;
        latitude = builder.latitude;
        longititude = builder.longititude;
        facilityType = builder.facilityType;
        city = builder.city;
        address = builder.address;
        positions = builder.positions;
        facilityMentors = builder.facilityMentors;
        facilityGrouping = builder.facilityGrouping;

    }

    public static class Builder {

        private final String facilityName;
        private String id;
        private String latitude;
        private String longititude;
        private FacilityType facilityType;
        private Location city;
        private LocationAddress address;
        private List<Position> positions = new ArrayList<>();
        private List<FacilityMentors> facilityMentors = new ArrayList<>();
        private FacilityGrouping facilityGrouping;

        public Builder(String facilityName) {
            this.facilityName = facilityName;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder latitude(String value) {
            latitude = value;
            return this;
        }

        public Builder longititude(String value) {
            longititude = value;
            return this;
        }

        public Builder facilityType(FacilityType value) {
            facilityType = value;
            return this;
        }

        public Builder city(Location value) {
            city = value;
            return this;
        }

        public Builder address(LocationAddress value) {
            address = value;
            return this;
        }

        public Builder positions(List<Position> value) {
            positions = value;
            return this;
        }

        public Builder facilityMentors(List<FacilityMentors> value) {
            facilityMentors = value;
            return this;
        }

        public Builder facilityGrouping(FacilityGrouping value) {
            facilityGrouping = value;
            return this;
        }

        public Builder facility(Facility facility) {
            id = facility.getId();
            facilityType = facility.getFacilityType();
            longititude = facility.getLongititude();
            latitude = facility.getLatitude();
            city = facility.getCity();
            address = facility.getAddress();
            positions = facility.getPositions();
            facilityMentors = facility.getFacilityMentors();
            facilityGrouping = facility.getFacilityGrouping();
            return this;

        }

        public Facility build() {
            return new Facility(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongititude() {
        return longititude;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public Location getCity() {
        return city;
    }

    public LocationAddress getAddress() {
        return address;
    }

    public List<Position> getPositions() {
        return ImmutableList.copyOf(positions);
    }

    public List<FacilityMentors> getFacilityMentors() {
        return ImmutableList.copyOf(facilityMentors);
    }

    public FacilityGrouping getFacilityGrouping() {
        return facilityGrouping;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facility)) {
            return false;
        }
        Facility other = (Facility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.offices.Facility[id=" + id + "]";
    }

    @Override
    public int compareTo(Facility o) {
        return facilityName.compareTo(o.facilityName);
    }
}
