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
public class MentoringToolsMethodsBean implements Serializable {

    private String id;
    private String toolsMethod;

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
     * @return the toolsMethod
     */
    public String getToolsMethod() {
        return toolsMethod;
    }

    /**
     * @param toolsMethod the toolsMethod to set
     */
    public void setToolsMethod(String toolsMethod) {
        this.toolsMethod = toolsMethod;
    }
}
