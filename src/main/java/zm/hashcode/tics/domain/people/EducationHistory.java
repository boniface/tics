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
public final class EducationHistory implements Serializable {

    private String instituteName;
    @DBRef
    private Location location;
    private Date graduationDate;
    private String major;

    private EducationHistory() {
    }

    private EducationHistory(Builder builder) {
        instituteName = builder.instituteName;
        location = builder.Location;
        graduationDate = builder.graduationDate;
        major= builder.major;

    }

    public static class Builder {

        private final String instituteName;
        private Location Location;
        private Date graduationDate;
        private String major;

        public Builder(String val) {
            this.instituteName = val;
        }

        public Builder graduationDate(Date value) {
            graduationDate = value;
            return this;
        }

        public Builder major(String value) {
            major = value;
            return this;
        }

        public Builder location(Location value) {
            Location = value;
            return this;
        }

        public EducationHistory build() {
            return new EducationHistory(this);
        }
    }

    public String getInstituteName() {
        return instituteName;
    }

    public Location getLocation() {
        return location;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public String getMajor() {
        return major;
    }
    
}
