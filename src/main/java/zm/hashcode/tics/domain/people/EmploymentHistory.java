/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author boniface
 */

public class EmploymentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private String companyName;
    private String companyAddress;
    private String companyTelephone;
    private String supervisor;
    private String reasonForLeaving;
    private Date dateSarted;

    private String startingPosition;

    private String endingPosition;
    private String jobResponsibilities;

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyAddress
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress the companyAddress to set
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return the companyTelephone
     */
    public String getCompanyTelephone() {
        return companyTelephone;
    }

    /**
     * @param companyTelephone the companyTelephone to set
     */
    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    /**
     * @return the supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the reasonForLeaving
     */
    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    /**
     * @param reasonForLeaving the reasonForLeaving to set
     */
    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

   
    /**
     * @return the startingPosition
     */
    public String getStartingPosition() {
        return startingPosition;
    }

    /**
     * @param startingPosition the startingPosition to set
     */
    public void setStartingPosition(String startingPosition) {
        this.startingPosition = startingPosition;
    }

    /**

     * @return the endingPosition
     */
    public String getEndingPosition() {
        return endingPosition;
    }

    /**
     * @param endingPosition the endingPosition to set
     */
    public void setEndingPosition(String endingPosition) {
        this.endingPosition = endingPosition;
    }

    /**
     * @return the jobResponsibilities
     */
    public String getJobResponsibilities() {
        return jobResponsibilities;
    }

    /**
     * @param jobResponsibilities the jobResponsibilities to set
     */
    public void setJobResponsibilities(String jobResponsibilities) {
        this.jobResponsibilities = jobResponsibilities;
    }

   
   
}
