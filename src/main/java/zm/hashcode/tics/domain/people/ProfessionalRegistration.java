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
public final class ProfessionalRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @DBRef
    private RegistrationBody registrationBody;
    private String registrationNumber;
    private Date registrationDate;
    private String licenceNumber;
    private Date expirationDate;

    private ProfessionalRegistration() {
    }

    private ProfessionalRegistration(Builder builder) {
        registrationBody = builder.registrationBody;
        registrationNumber = builder.registrationNumber;
        registrationDate = builder.registrationDate;
        licenceNumber = builder.licenceNumber;
        expirationDate = builder.expirationDate;

    }

    public static class Builder {

        private final RegistrationBody registrationBody;
        private String registrationNumber;
        private Date registrationDate;
        private String licenceNumber;
        private Date expirationDate;

        public Builder(RegistrationBody val) {
            this.registrationBody = val;
        }

        public Builder registrationNumber(String value) {
            registrationNumber = value;
            return this;
        }

        public Builder licenceNumber(String value) {
            licenceNumber = value;
            return this;
        }

        public Builder registrationDate(Date value) {
            registrationDate = value;
            return this;
        }

        public Builder expirationDate(Date value) {
            expirationDate = value;
            return this;
        }

        public ProfessionalRegistration build() {
            return new ProfessionalRegistration(this);
        }
    }

    public RegistrationBody getRegistrationBody() {
        return registrationBody;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    
}
