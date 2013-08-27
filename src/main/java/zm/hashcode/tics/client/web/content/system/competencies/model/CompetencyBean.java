/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class CompetencyBean implements Serializable {

    private String id;
    private String name;
    private String competencyTypeId;
    private String notes;

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
     * @return the competencyTypeId
     */
    public String getCompetencyTypeId() {
        return competencyTypeId;
    }

    /**
     * @param competencyTypeId the competencyTypeId to set
     */
    public void setCompetencyTypeId(String CompetencyTypeId) {
        this.competencyTypeId = CompetencyTypeId;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
