/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.position;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.util.Status;



/**
 *
 * @author boniface
 */
@Document
public class Position implements Serializable, Comparable<Position> {
    private static long serialVersionUID = 1L;
    @Id
    private String id;
    private String positionCode;
    //Make it from Job and Position Title Nurse-Code
    private String positionTitle;
    private String description;
    private Date postionEntryDate;
    private Date positionEndDate;
    @DBRef
    private Person currentOccupant;
    @DBRef
    private PositionType positionType;
    @DBRef
    private Status positionStatus;
    private String positionComments;
    @DBRef
    private Facility facility;
    private List<String> subodinateIds = new ArrayList<String>();
    @DBRef
    private Position supervisor;
    @DBRef
    private Department department;
    @DBRef
    private Job job;

    public String getId() {
        return id;
    }

    public Person getCurrentOccupant() {
        return currentOccupant;
    }

    public void setCurrentOccupant(Person currentOccupant) {
        this.currentOccupant = currentOccupant;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Position.serialVersionUID = serialVersionUID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.positions.Positions[id=" + getId() + "]";
    }

    /**
     * @return the job
     */
    public Job getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(Job job) {
        this.job = job;
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
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the positionStatus
     */
    public Status getPositionStatus() {
        return positionStatus;
    }

    /**
     * @param positionStatus the positionStatus to set
     */
    public void setPositionStatus(Status positionStatus) {
        this.positionStatus = positionStatus;
    }

    /**
     * @return the positionType
     */
    public PositionType getPositionType() {
        return positionType;
    }

    /**
     * @param positionType the positionType to set
     */
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    /**
     * @return the supervisor
     */
    public Position getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Position supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int compareTo(Position o) {
        return positionCode.compareTo(o.positionCode);
    }

    /**
     * @return the positionTitle
     */
    public String getPositionTitle() {
        return positionTitle;
    }

    public List<String> getSubodinateIds() {
        return subodinateIds;
    }

    public void setSubodinateIds(List<String> subodinateIds) {
        this.subodinateIds = subodinateIds;
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
     * @return the postionEntryDate
     */
    public Date getPostionEntryDate() {
        return postionEntryDate;
    }

    /**
     * @param postionEntryDate the postionEntryDate to set
     */
    public void setPostionEntryDate(Date postionEntryDate) {
        this.postionEntryDate = postionEntryDate;
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

    
}
