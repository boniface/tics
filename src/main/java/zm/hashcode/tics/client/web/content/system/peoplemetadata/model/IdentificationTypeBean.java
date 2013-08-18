/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class IdentificationTypeBean implements Serializable {

    private String id;
    private String idvalue;
    private String description;

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
     * @return the idvalue
     */
    public String getIdvalue() {
        return idvalue;
    }

    /**
     * @param idvalue the idvalue to set
     */
    public void setIdvalue(String idvalue) {
        this.idvalue = idvalue;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
