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
public class AddressTypeBean implements Serializable {

    private String id;
    //Home Address or Work Address
    private String addressTypeName;

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
     * @return the addressTypeName
     */
    public String getAddressTypeName() {
        return addressTypeName;
    }

    /**
     * @param addressTypeName the addressTypeName to set
     */
    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }
}
