/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.DBRef;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */

public class EducationHistory implements Serializable {

    private String instituteNamwe;
    @DBRef
    private Location Location;
    private Date graduation;
    @DBRef
   
    private String major;
    /**
     * @return the instituteNamwe
     */
    public String getInstituteNamwe() {
        return instituteNamwe;
    }

    /**
     * @param instituteNamwe the instituteNamwe to set
     */
    public void setInstituteNamwe(String instituteNamwe) {
        this.instituteNamwe = instituteNamwe;
    }

 

    /**
     * @return the graduation
     */
    public Date getGraduation() {
        return graduation;
    }

    /**
     * @param graduation the graduation to set
     */
    public void setGraduation(Date graduation) {
        this.graduation = graduation;
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
