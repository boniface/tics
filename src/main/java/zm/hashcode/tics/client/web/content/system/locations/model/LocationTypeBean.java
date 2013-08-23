/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class LocationTypeBean implements Serializable {

    private String id;
    private String name;
    private String code;
    private String locationTypeParentId;

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
     * @return the locationTypeParentId
     */
    public String getLocationTypeParentId() {
        return locationTypeParentId;
    }

    /**
     * @param locationTypeParentId the locationTypeParentId to set
     */
    public void setLocationTypeParentId(String locationTypeParentId) {
        this.locationTypeParentId = locationTypeParentId;
    }
}
