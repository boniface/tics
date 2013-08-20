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
public class JobClassificationBean implements Serializable {

    private String id;
    private String currentTitle;
    private String oldTitle;
    private String oldCode;
    private String currentCode;
    private String codeConversion;
    private String comment;

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
     * @return the currentTitle
     */
    public String getCurrentTitle() {
        return currentTitle;
    }

    /**
     * @param currentTitle the currentTitle to set
     */
    public void setCurrentTitle(String currentTitle) {
        this.currentTitle = currentTitle;
    }

    /**
     * @return the oldTitle
     */
    public String getOldTitle() {
        return oldTitle;
    }

    /**
     * @param oldTitle the oldTitle to set
     */
    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    /**
     * @return the oldCode
     */
    public String getOldCode() {
        return oldCode;
    }

    /**
     * @param oldCode the oldCode to set
     */
    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    /**
     * @return the currentCode
     */
    public String getCurrentCode() {
        return currentCode;
    }

    /**
     * @param currentCode the currentCode to set
     */
    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    /**
     * @return the codeConversion
     */
    public String getCodeConversion() {
        return codeConversion;
    }

    /**
     * @param codeConversion the codeConversion to set
     */
    public void setCodeConversion(String codeConversion) {
        this.codeConversion = codeConversion;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
