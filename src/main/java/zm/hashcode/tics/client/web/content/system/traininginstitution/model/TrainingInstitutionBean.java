/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.traininginstitution.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geek
 */
public class TrainingInstitutionBean implements Serializable {

    private String id;
    private String name; //******
//    @DBRef
//    private Location city;
    private String LocationId;
//    private Contact contact;
//    @DBRef
//    private List<User> users;
    private Set<String> usersIds = new HashSet<>();
//    @DBRef
//    private List<TrainingInstructors> trainingInstructors;
    private Set<String> trainingInstructorsIds = new HashSet<>();
//    @DBRef
//    private List<Course> courses;
    private Set<String> coursesIds = new HashSet<>();
//    @DBRef
//    private List<ScheduledCourse> scheduledCourseses
    private Set<String> scheduledCoursesIds = new HashSet<>();

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
     * @return the LocationId
     */
    public String getLocationId() {
        return LocationId;
    }

    /**
     * @param LocationId the LocationId to set
     */
    public void setLocationId(String LocationId) {
        this.LocationId = LocationId;
    }

    /**
     * @return the usersIds
     */
    public Set<String> getUsersIds() {
        return usersIds;
    }

    /**
     * @param usersIds the usersIds to set
     */
    public void setUsersIds(Set<String> usersIds) {
        this.usersIds = usersIds;
    }

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
     * @return the coursesIds
     */
    public Set<String> getCoursesIds() {
        return coursesIds;
    }

    /**
     * @param coursesIds the coursesIds to set
     */
    public void setCoursesIds(Set<String> coursesIds) {
        this.coursesIds = coursesIds;
    }

    /**
     * @return the scheduledCoursesIds
     */
    public Set<String> getScheduledCoursesIds() {
        return scheduledCoursesIds;
    }

    /**
     * @param scheduledCoursesIds the scheduledCoursesIds to set
     */
    public void setScheduledCoursesIds(Set<String> scheduledCoursesIds) {
        this.scheduledCoursesIds = scheduledCoursesIds;
    }
}
