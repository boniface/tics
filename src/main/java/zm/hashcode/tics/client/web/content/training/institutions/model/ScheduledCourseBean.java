/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author geek
 */
public class ScheduledCourseBean implements Serializable {

    private String id;
    private String venue;
    private String notes;
    private int courseCapacity;
    private int creditHours;
    private Date startDate;
    private Date endDate;
    private String courseId; // EMBEDDABLE
    private String locationId; // EMBEDDABLE
//    private Set<String> personsIds;
    private Set<String> trainingInstructorsIds;
    private Set<String> fundersIds;

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
     * @return the venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(String venue) {
        this.venue = venue;
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

    /**
     * @return the courseCapacity
     */
    public int getCourseCapacity() {
        return courseCapacity;
    }

    /**
     * @param courseCapacity the courseCapacity to set
     */
    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    /**
     * @return the creditHours
     */
    public int getCreditHours() {
        return creditHours;
    }

    /**
     * @param creditHours the creditHours to set
     */
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

//    /**
//     * @return the personsIds
//     */
//    public Set<String> getPersonsIds() {
//        return personsIds;
//    }
//
//    /**
//     * @param personsIds the personsIds to set
//     */
//    public void setPersonsIds(Set<String> personsIds) {
//        this.personsIds = personsIds;
//    }
    /**
     * @return the trainingInstructorsIds
     */
    public Set<String> getTrainingInstructorsIds() {
        return trainingInstructorsIds;
    }

    /**
     * @param trainingInstructorsIds the trainingInstructorsIds to set
     */
    public void setTrainingInstructorsIds(Set<String> trainingInstructorsIds) {
        this.trainingInstructorsIds = trainingInstructorsIds;
    }

    /**
     * @return the fundersIds
     */
    public Set<String> getFundersIds() {
        return fundersIds;
    }

    /**
     * @param fundersIds the fundersIds to set
     */
    public void setFundersIds(Set<String> fundersIds) {
        this.fundersIds = fundersIds;
    }
}
