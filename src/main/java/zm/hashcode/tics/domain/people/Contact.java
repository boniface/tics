/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public final class Contact implements Serializable {

    private String mailingAddress;
    private String telephoneNumber;
    private String cellnumber;
    private String faxnumber;
    private String email;
    private String addressType;

    private Contact() {
    }

    private Contact(Builder builder) {

        email = builder.email;
        mailingAddress = builder.mailingAddress;
        telephoneNumber = builder.telephoneNumber;
        cellnumber = builder.cellnumber;
        faxnumber = builder.faxnumber;
        addressType = builder.addressType;


    }

    public static class Builder {

        private String mailingAddress;
        private String telephoneNumber;
        private String cellnumber;
        private String faxnumber;
        private final String email;
        private String addressType;

        public Builder(String email) {
            this.email = email;
        }

        public Builder mailingAddress(String value) {
            mailingAddress = value;
            return this;
        }

        public Builder telephoneNumber(String value) {
            telephoneNumber = value;
            return this;
        }

        public Builder cellnumber(String value) {
            cellnumber = value;
            return this;
        }

        public Builder faxnumber(String value) {
            faxnumber = value;
            return this;
        }

        public Builder addressType(String value) {
            addressType = value;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
