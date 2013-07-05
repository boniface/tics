/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.location.RegistrationBody;

/**
 *
 * @author boniface
 */
public class ProfessionalRegistration implements Serializable {
    private static final long serialVersionUID = 1L;
    @DBRef
    private RegistrationBody registrationBody;
    private String registrationNumber;
    private Date registrationDate;
    private String licenceNumber;
    private Date expirationDate;

    /**
     * @return the registrationBody
     */
    public RegistrationBody getRegistrationBody() {
        return registrationBody;
    }

    /**
     * @param registrationBody the registrationBody to set
     */
    public void setRegistrationBody(RegistrationBody registrationBody) {
        this.registrationBody = registrationBody;
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
