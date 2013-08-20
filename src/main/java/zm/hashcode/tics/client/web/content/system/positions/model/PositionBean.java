/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geek
 */
public class PositionBean implements Serializable {

    private String id;
    private String positionCode;
    //Make it from Job and Position Title Nurse-Code
    private String positionTitle;
    private String positionComments;
    private String description;
    private Date positionEntryDate;
    private Date positionEndDate;
//    @DBRef
//    private Person currentOccupant;
    private String personId;
//    @DBRef
//    private PositionType positionType;
    private String positionTypeId;
//    @DBRef
//    private Status positionStatus;
    private String statusId;
//    @DBRef
//    private Facility facility;
    private String facilityId;
//    private List<String> subodinateIds;
    private Set<String> subodinateIds = new HashSet<>();
//    @DBRef
//    private Position supervisor;
    private String positionId;
//    @DBRef
//    private Department department;
    private String departmentId;
//    @DBRef
//    private Job job;
    private String jobId;

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
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    /**
     * @param positionCode the positionCode to set
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    /**
     * @return the positionTitle
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    /**
     * @param positionTitle the positionTitle to set
     */
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
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
     * @return the positionEntryDate
     */
    public Date getPositionEntryDate() {
        return positionEntryDate;
    }

    /**
     * @param positionEntryDate the positionEntryDate to set
     */
    public void setPositionEntryDate(Date positionEntryDate) {
        this.positionEntryDate = positionEntryDate;
    }

    /**
     * @return the positionEndDate
     */
    public Date getPositionEndDate() {
        return positionEndDate;
    }

    /**
     * @param positionEndDate the positionEndDate to set
     */
    public void setPositionEndDate(Date positionEndDate) {
        this.positionEndDate = positionEndDate;
    }

    /**
     * @return the personId
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * @return the positionTypeId
     */
    public String getPositionTypeId() {
        return positionTypeId;
    }

    /**
     * @param positionTypeId the positionTypeId to set
     */
    public void setPositionTypeId(String positionTypeId) {
        this.positionTypeId = positionTypeId;
    }

    /**
     * @return the statusId
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * @return the positionComments
     */
    public String getPositionComments() {
        return positionComments;
    }

    /**
     * @param positionComments the positionComments to set
     */
    public void setPositionComments(String positionComments) {
        this.positionComments = positionComments;
    }

    /**
     * @return the facilityId
     */
    public String getFacilityId() {
        return facilityId;
    }

    /**
     * @param facilityId the facilityId to set
     */
    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    /**
     * @return the subodinateIds
     */
    public Set<String> getSubodinateIds() {
        return subodinateIds;
    }

    /**
     * @param subodinateIds the subodinateIds to set
     */
    public void setSubodinateIds(Set<String> subodinateIds) {
        this.subodinateIds = subodinateIds;
    }

    /**
     * @return the positionId
     */
    public String getPositionId() {
        return positionId;
    }

    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    /**
     * @return the departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
