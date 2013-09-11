/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author geek
 */
public class ProfessionalRegistrationBean implements Serializable {
//        @DBRef

    private String registrationBodyId; // RegistrationBody  *********
    private String registrationNumber;
    private Date registrationDate;
    private String licenceNumber;
    private Date expirationDate;

    /**
     * @return the registrationBodyId
     */
    public String getRegistrationBodyId() {
        return registrationBodyId;
    }

    /**
     * @param registrationBodyId the registrationBodyId to set
     */
    public void setRegistrationBodyId(String registrationBodyId) {
        this.registrationBodyId = registrationBodyId;
    }

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the licenceNumber
     */
    public String getLicenceNumber() {
        return licenceNumber;
    }

    /**
     * @param licenceNumber the licenceNumber to set
     */
    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
