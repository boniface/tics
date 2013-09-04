/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class SessionAreasOfStrengtheningBean implements Serializable {

    private String id;
    private String areasOfStrengthening;

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
     * @return the areasOfStrengthening
     */
    public String getAreasOfStrengthening() {
        return areasOfStrengthening;
    }

    /**
     * @param areasOfStrengthening the areasOfStrengthening to set
     */
    public void setAreasOfStrengthening(String areasOfStrengthening) {
        this.areasOfStrengthening = areasOfStrengthening;
    }
}
