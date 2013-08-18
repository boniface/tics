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
public class RaceBean implements Serializable {

    private String id;
    private String raceName;

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
     * @return the raceName
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * @param raceName the raceName to set
     */
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
