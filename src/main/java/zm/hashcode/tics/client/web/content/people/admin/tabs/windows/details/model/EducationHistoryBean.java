/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author geek
 */
public class EducationHistoryBean implements Serializable {

    private String instituteName;
//    @DBRef
    private String locationId; // Location
    private Date graduationDate;
    private String major;

    /**
     * @return the instituteName
     */
    public String getInstituteName() {
        return instituteName;
    }

    /**
     * @param instituteName the instituteName to set
     */
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the graduationDate
     */
    public Date getGraduationDate() {
        return graduationDate;
    }

    /**
     * @param graduationDate the graduationDate to set
     */
    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }
}
