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
public class LanguageProficiencyBean implements Serializable {

    private String id;
    private String proficiency;

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
     * @return the proficiency
     */
    public String getProficiency() {
        return proficiency;
    }

    /**
     * @param proficiency the proficiency to set
     */
    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
