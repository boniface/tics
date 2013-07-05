/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.training.MentoringSession;

/**
 *
 * @author boniface
 */
@Document
public class EmployeeMentoring implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Date mentoringDate;
    private Long patientsInitiated;
    private Long hoursSpent;
    @DBRef
    private MentoringSession mentoringSession;
    @DBRef
    private Facility venue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeMentoring)) {
            return false;
        }
        EmployeeMentoring other = (EmployeeMentoring) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.Training[id=" + id + "]";
    }

    
    /**
     * @return the mentoringSession
     */
    public MentoringSession getMentoringSession() {
        return mentoringSession;
    }

    /**
     * @param mentoringSession the mentoringSession to set
     */
    public void setMentoringSession(MentoringSession mentoringSession) {
        this.mentoringSession = mentoringSession;
    }

    /**
     * @return the mentoringDate
     */
    public Date getMentoringDate() {
        return mentoringDate;
    }

    /**
     * @param mentoringDate the mentoringDate to set
     */
    public void setMentoringDate(Date mentoringDate) {
        this.mentoringDate = mentoringDate;
    }

    /**
     * @return the patientsInitiated
     */
    public Long getPatientsInitiated() {
        return patientsInitiated;
    }

    /**
     * @param patientsInitiated the patientsInitiated to set
     */
    public void setPatientsInitiated(Long patientsInitiated) {
        this.patientsInitiated = patientsInitiated;
    }

    /**
     * @return the hoursSpent
     */
    public Long getHoursSpent() {
        return hoursSpent;
    }

    /**
     * @param hoursSpent the hoursSpent to set
     */
    public void setHoursSpent(Long hoursSpent) {
        this.hoursSpent = hoursSpent;
    }

    /**
     * @return the venue
     */
    public Facility getVenue() {
        return venue;
    }

    /**
     * @param venue the venue to set
     */
    public void setVenue(Facility venue) {
        this.venue = venue;
    }
}
