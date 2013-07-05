/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.offices;

import java.io.Serializable;

/**
 *
 * @author boniface
 */
public final class FacilityMentors implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String mentorId;

    private FacilityMentors() {
    }

    private FacilityMentors(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        mentorId = builder.mentorId;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private final String mentorId;

        public Builder(String val) {
            this.mentorId = val;
        }

        public Builder firstName(String value) {
            firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            lastName = value;
            return this;
        }

        public FacilityMentors build() {
            return new FacilityMentors(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMentorId() {
        return mentorId;
    }
}
