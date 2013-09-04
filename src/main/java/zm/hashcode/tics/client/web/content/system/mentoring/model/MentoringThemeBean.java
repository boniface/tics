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
public class MentoringThemeBean implements Serializable {

    private String id;
    private String mentoringTheme;
    private String mentoringFieldId; // MentoringField

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
     * @return the mentoringTheme
     */
    public String getMentoringTheme() {
        return mentoringTheme;
    }

    /**
     * @param mentoringTheme the mentoringTheme to set
     */
    public void setMentoringTheme(String mentoringTheme) {
        this.mentoringTheme = mentoringTheme;
    }

    /**
     * @return the mentoringFieldId
     */
    public String getMentoringFieldId() {
        return mentoringFieldId;
    }

    /**
     * @param mentoringFieldId the mentoringFieldId to set
     */
    public void setMentoringFieldId(String mentoringFieldId) {
        this.mentoringFieldId = mentoringFieldId;
    }
}
