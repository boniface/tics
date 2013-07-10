/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.location;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author boniface
 */
@Document
public final class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String code;
    private String latitude;
    private String longitude;
    @DBRef
    private LocationType locationType;
    @DBRef
    private List<Location> children;
    @DBRef
    private Location parent;

    private Location() {
    }

    private Location(Builder builder) {
        id = builder.id;
        name = builder.name;
        code = builder.code;
        latitude = builder.latitude;
        longitude = builder.longitude;
        locationType = builder.locationType;
        children = builder.children;
        parent = builder.parent;
    }

    public static class Builder {

        private String id;
        private String name;
        private String code;
        private String latitude;
        private String longitude;
        private LocationType locationType;
        private Location parent;
        private List<Location> children = new ArrayList<>();
//        //        return ImmutableList.copyOf(roles);

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder code(String value) {
            code = value;
            return this;
        }

        public Builder children(List<Location> value) {
            children = value;
            return this;
        }

        public Builder latitude(String value) {
            code = value;
            return this;
        }

        public Builder longitude(String value) {
            code = value;
            return this;
        }

        public Builder locationType(String value) {
            code = value;
            return this;
        }

        public Builder parent(String value) {
            code = value;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public List<Location> getChildren() {
        return ImmutableList.copyOf(children);
    }

    public Location getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + '}';
    }
    
}
