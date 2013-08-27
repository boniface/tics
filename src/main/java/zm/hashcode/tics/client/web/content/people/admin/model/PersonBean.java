/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author boniface
 */
public class PersonBean implements Serializable {

    private String id;
    @NotNull
    private String firstname;
    @NotNull
    private String surname;
    private String othername;
    private String identitiesId;
    private String idValue;
    @NotNull
    private String facilityId;
    @NotNull
    private String titleId;
    @NotNull
    private String genderId;
    @NotNull
    private String raceId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getIdentitiesId() {
        return identitiesId;
    }

    public void setIdentitiesId(String identitiesId) {
        this.identitiesId = identitiesId;
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }
}
