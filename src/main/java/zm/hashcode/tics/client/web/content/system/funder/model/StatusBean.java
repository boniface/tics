/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class StatusBean implements Serializable {

    private String id;
    private String statusType;//**********
    private String statusValue;

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
     * @return the statusType
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the statusValue
     */
    public String getStatusValue() {
        return statusValue;
    }

    /**
     * @param statusValue the statusValue to set
     */
    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }
}
