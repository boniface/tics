/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.model;

import java.io.Serializable;

/**
 *
 * @author geek
 */
public class ContactAddressBean implements Serializable {

//  private LocationAddress address;
    // Blow out LocationAddress
    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddres;
//    @DBRef
//    private Location city;
    private String cityId;
    private String cityName;

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
     * @return the emailAddres
     */
    public String getEmailAddres() {
        return emailAddres;
    }

    /**
     * @param emailAddres the emailAddres to set
     */
    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
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

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
