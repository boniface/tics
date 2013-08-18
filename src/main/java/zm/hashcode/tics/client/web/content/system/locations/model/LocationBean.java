/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.model;

import java.io.Serializable;
import java.util.List;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationBean implements Serializable {

    private String id;
    private String name;
    private String code;
    private String latitude;
    private String longitude;
//    @DBRef
    private LocationType locationType;
    private String locationTypeId;
//    @DBRef
    private List<Location> children;
//    @DBRef
    private Location parent;
    private String locationId;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the locationType
     */
    public LocationType getLocationType() {
        return locationType;
    }

    /**
     * @param locationType the locationType to set
     */
    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    /**
     * @return the children
     */
    public List<Location> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Location> children) {
        this.children = children;
    }

    /**
     * @return the parent
     */
    public Location getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Location parent) {
        this.parent = parent;
    }

    /**
     * @return the locationTypeId
     */
    public String getLocationTypeId() {
        return locationTypeId;
    }

    /**
     * @param locationTypeId the locationTypeId to set
     */
    public void setLocationTypeId(String locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
