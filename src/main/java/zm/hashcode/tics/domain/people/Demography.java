/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author boniface
 */

public class Demography implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date dob;
    private String gender;
    private String maritalStatus;
    private int dependants;
    private String race;

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the dependants
     */
    public int getDependants() {
        return dependants;
    }

    /**
     * @param dependants the dependants to set
     */
    public void setDependants(int dependants) {
        this.dependants = dependants;
    }

    /**
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(String race) {
        this.race = race;
    }

}
