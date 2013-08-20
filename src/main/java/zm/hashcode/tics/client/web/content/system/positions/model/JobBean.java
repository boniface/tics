/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geek
 */
public class JobBean implements Serializable {

    private String id;
    private String title;
    private String code;
    private String description;
//    @DBRef
//    private JobClassification jobClassification;
//    @DBRef
//    private List<Position> positions;
    private String jobClassificationId;
    private Set<String> positionIds = new HashSet<>();

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the jobClassificationId
     */
    public String getJobClassificationId() {
        return jobClassificationId;
    }

    /**
     * @param jobClassificationId the jobClassificationId to set
     */
    public void setJobClassificationId(String jobClassificationId) {
        this.jobClassificationId = jobClassificationId;
    }

    /**
     * @return the positionIds
     */
    public Set<String> getPositionIds() {
        return positionIds;
    }

    /**
     * @param positionIds the positionIds to set
     */
    public void setPositionIds(Set<String> positionIds) {
        this.positionIds = positionIds;
    }
}
