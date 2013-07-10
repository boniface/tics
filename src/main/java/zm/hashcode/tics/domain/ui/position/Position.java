/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.position;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    private List<String> subodinateIds;
    @DBRef
    private Position supervisor;
    @DBRef
    private Department department;
    @DBRef
    private Job job;

    private Position() {
    }

    private Position(Builder builder) {
        id = builder.id;
        positionCode = builder.positionCode;
        positionComments = builder.positionComments;
        positionEndDate = builder.positionEndDate;
        positionStatus = builder.positionStatus;
        positionTitle = builder.positionTitle;
        positionType = builder.positionType;
        currentOccupant = builder.currentOccupant;
        department = builder.department;
        description = builder.description;
        facility = builder.facility;
        job = builder.job;
        subodinateIds = builder.subodinateIds;
        supervisor = builder.supervisor;
        postionEntryDate = builder.postionEntryDate;
    }

    public static class Builder {

        private String id;
        private String positionCode;
        //Make it from Job and Position Title Nurse-Code
        private final String positionTitle;
        private String description;
        private Date postionEntryDate;
        private Date positionEndDate;
        private Person currentOccupant;
        private PositionType positionType;
        private Status positionStatus;
        private String positionComments;
        private Facility facility;
        private List<String> subodinateIds;
        private Position supervisor;
        private Department department;
        private Job job;

        public Builder(String val) {
            this.positionTitle = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder positionCode(String value) {
            positionCode = value;
            return this;
        }

        public Builder roles(List<String> value) {
            subodinateIds = value;
            return this;
        }

        public Builder job(Job value) {
            job = value;
            return this;
        }

        public Builder department(Department value) {
            department = value;
            return this;
        }

        public Builder supervisor(Position value) {
            supervisor = value;
            return this;
        }

        public Builder positionComments(String value) {
            positionComments = value;
            return this;
        }

        public Builder facility(Facility value) {
            facility = value;
            return this;
        }

        public Builder positionStatus(Status value) {
            positionStatus = value;
            return this;
        }

        public Builder positionType(PositionType value) {
            positionType = value;
            return this;
        }

        public Builder currentOccupant(Person value) {
            currentOccupant = value;
            return this;
        }

        public Builder postionEntryDate(Date value) {
            postionEntryDate = value;
            return this;
        }

        public Builder positionEndDate(Date value) {
            positionEndDate = value;
            return this;
        }

        public Builder description(String value) {
            description = value;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }

    @Override
    public int compareTo(Position o) {
        return positionCode.compareTo(o.positionCode);
    }

    public String getId() {
        return id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public String getDescription() {
        return description;
    }

    public Date getPostionEntryDate() {
        return postionEntryDate;
    }

    public Date getPositionEndDate() {
        return positionEndDate;
    }

    public Person getCurrentOccupant() {
        return currentOccupant;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Status getPositionStatus() {
        return positionStatus;
    }

    public String getPositionComments() {
        return positionComments;
    }

    public Facility getFacility() {
        return facility;
    }

    public List<String> getSubodinateIds() {
        return subodinateIds;
    }

    public Position getSupervisor() {
        return supervisor;
    }

    public Department getDepartment() {
        return department;
    }

    public Job getJob() {
        return job;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Position{" + "positionCode=" + positionCode + ", positionTitle=" + positionTitle + '}';
    }
}
