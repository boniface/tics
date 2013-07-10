/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.ui.location;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public final class LocationAddress implements Serializable {

    private String postalAddress;
    private String physicalAddress;
    private String contactNumber;
    private String postalCode;
    private String emailAddress;

    private LocationAddress() {
    }

    private LocationAddress(Builder builder) {
        postalAddress = builder.postalAddress;
        physicalAddress = builder.physicalAddress;
        contactNumber = builder.contactNumber;
        postalCode = builder.postalCode;
        emailAddress = builder.emailAddress;
    }

    public static class Builder {

        private String postalAddress;
        private String physicalAddress;
        private final String contactNumber;
        private String postalCode;
        private String emailAddress;

        public Builder(String val) {
            this.contactNumber = val;
        }

        public Builder postalAddress(String value) {
            postalAddress = value;
            return this;
        }

        public Builder physicalAddress(String value) {
            physicalAddress = value;
            return this;
        }

        public Builder postalCode(String value) {
            postalCode = value;
            return this;
        }
        
        
        public Builder emailAddress(String value) {
            emailAddress = value;
            return this;
        }

        public LocationAddress build() {
            return new LocationAddress(this);
        }
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "LocationAddress{" + "postalCode=" + postalCode + ", emailAddress=" + emailAddress + '}';
    }
    
    
}