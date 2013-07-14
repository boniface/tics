/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.MaritalStatus;
import zm.hashcode.tics.domain.ui.demographics.Race;

/**
 * @author boniface
 */
public final class Demography implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date dob;
    @DBRef
    private Gender gender;
    @DBRef
    private MaritalStatus maritalStatus;
    private int dependants;
    @DBRef
    private Race race;

    private Demography() {
    }

    public Demography(Builder builder) {
        dob = builder.dob;
        gender = builder.gender;
        maritalStatus = builder.maritalStatus;
        dependants = builder.dependants;
        race = builder.race;
    }

    public static class Builder {

        private Date dob;
        private final Gender gender;
        private MaritalStatus maritalStatus;
        private int dependants;
        private Race race;

        public Builder(Gender gender) {
            this.gender = gender;
        }

        public Builder dob(Date val) {
            dob = val;
            return this;
        }

        public Builder maritalStatus(MaritalStatus val) {
            maritalStatus = val;
            return this;
        }

        public Builder dependants(int val) {
            dependants = val;
            return this;
        }

        public Builder race(Race val) {
            race = val;
            return this;
        }

        public Demography build() {
            return new Demography(this);
        }
    }

    public Date getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public int getDependants() {
        return dependants;
    }

    public Race getRace() {
        return race;
    }
}
