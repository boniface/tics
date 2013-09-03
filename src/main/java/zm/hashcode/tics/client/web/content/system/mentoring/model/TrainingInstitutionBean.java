/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.model;

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
//    List<InstitutionAddress> institutionAddresses;
//    private Set<String> institutionAddressesIds = new HashSet<>();  // THis is and EMBEDDABLE, just blow up the attribute as below
    ////////?????????????????????????????????
//    private LocationAddress address; // THis is and EMBEDDABLE, just blow up the attribute as below
    ////////?????????????????????????????????
    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddress;
    ////////?????????????????????????????????
//    @DBRef
//    private Location city;
    private String cityId;
    ////////?????????????????????????????????
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
//
//    /**
//     * @return the institutionAddressesIds
//     */
//    public Set<String> getInstitutionAddressesIds() {
//        return institutionAddressesIds;
//    }
//
//    /**
//     * @param institutionAddressesIds the institutionAddressesIds to set
//     */
//    public void setInstitutionAddressesIds(Set<String> institutionAddressesIds) {
//        this.institutionAddressesIds = institutionAddressesIds;
//    }

    /**
     * @return the postalAddress
     */
    public String getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress the postalAddress to set
     */
    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the physicalAddress
     */
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    /**
     * @param physicalAddress the physicalAddress to set
     */
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the cityId
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId the cityId to set
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
