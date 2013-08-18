/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class FacilityMentorsBean implements Serializable {

    private String firstName;
    private String lastName;
    private String mentorId;

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
     * @return the mentorId
     */
    public String getMentorId() {
        return mentorId;
    }

    /**
     * @param mentorId the mentorId to set
     */
    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }
}
