/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 * @author boniface
 */

public final class Demography implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date dob;
    private String gender;
    private String maritalStatus;
    private int dependants;
    private String race;

    private  Demography() {

    }

    public Demography(Builder builder) {
        dob = builder.dob;
        gender= builder.gender;
        maritalStatus= builder.maritalStatus;
        dependants = builder.dependants;
        race= builder.race;
    }

    public static class Builder {
        private Date dob;
        private final String gender;
        private String maritalStatus;
        private int dependants;
        private String race;

        public Builder(String gender) {
            this.gender = gender;
        }

        public Builder dob(Date val) {
            dob = val;
            return this;
        }

        public Builder maritalStatus(String val) {
            maritalStatus = val;
            return this;
        }

        public Builder dependants(int val) {
            dependants = val;
            return this;
        }

        public Builder race(String val) {
            race = val;
            return this;
        }

        public Demography build(){
            return new Demography(this);
        }


    }

}
