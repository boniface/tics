/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class TrainingInstructorBean implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String otherName;
    private String qualification;
    private String areaOfexpertise;

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the otherName
     */
    public String getOtherName() {
        return otherName;
    }

    /**
     * @param otherName the otherName to set
     */
    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the areaOfexpertise
     */
    public String getAreaOfexpertise() {
        return areaOfexpertise;
    }

    /**
     * @param areaOfexpertise the areaOfexpertise to set
     */
    public void setAreaOfexpertise(String areaOfexpertise) {
        this.areaOfexpertise = areaOfexpertise;
    }
}
