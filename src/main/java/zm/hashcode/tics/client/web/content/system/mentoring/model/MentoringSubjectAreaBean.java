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
public class MentoringSubjectAreaBean implements Serializable {

    private String id;
    private String subjectArea;

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
     * @return the subjectArea
     */
    public String getSubjectArea() {
        return subjectArea;
    }

    /**
     * @param subjectArea the subjectArea to set
     */
    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }
}
