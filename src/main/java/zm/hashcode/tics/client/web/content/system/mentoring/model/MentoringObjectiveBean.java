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
public class MentoringObjectiveBean implements Serializable {

    private String id;
    private String mentoringObjective;

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
     * @return the mentoringObjective
     */
    public String getMentoringObjective() {
        return mentoringObjective;
    }

    /**
     * @param mentoringObjective the mentoringObjective to set
     */
    public void setMentoringObjective(String mentoringObjective) {
        this.mentoringObjective = mentoringObjective;
    }
}
