/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class DepartureReasonBean implements Serializable {

    private String id;
    //Full Time, PartTime, Causal , Hourly
    private String reasonName;
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
     * @return the reasonName
     */
    public String getReasonName() {
        return reasonName;
    }

    /**
     * @param reasonName the reasonName to set
     */
    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
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
