/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.reports;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * System.out.println(" Vanue " + c.getVenue() + " Name " +
 * c.getCourse().getName() + " Topic" + c.getCourse().getCourseTopic()
 *
 * @author boniface
 */
@Document
public class Report implements Serializable {

    @Id
    private String id;
    private String courseName;
    private String courseTopic;
    private String venue;
    private Date startDate;
    private Date endDate;
    private String firstName;
    private String personId;
    private String lastName;
    private String facility;
    private String city;
    private String substrict;
    private String district;

    private Report() {
    }

    private Report(Builder builder) {
        city = builder.city;
        courseName = builder.courseName;
        courseTopic = builder.courseTopic;
        district = builder.district;
        endDate = builder.endDate;
        facility = builder.facility;
        firstName = builder.firstName;
        id = builder.id;
        lastName = builder.lastName;
        personId = builder.personId;
        startDate = builder.startDate;
        substrict = builder.substrict;
        venue = builder.venue;
    }

    public static class Builder {

        private final String courseName;
        private String id;
        private String courseTopic;
        private String venue;
        private Date startDate;
        private Date endDate;
        private String firstName;
        private String personId;
        private String lastName;
        private String facility;
        private String city;
        private String substrict;
        private String district;

        public Builder(String courseName) {
            this.courseName = courseName;
        }

        public Builder id(String value) {
            this.id = value;
            return this;
        }

        public Builder city(String value) {
            this.city = value;
            return this;
        }

        public Builder courseTopic(String value) {
            this.courseTopic = value;
            return this;
        }

        public Builder district(String value) {
            this.district = value;
            return this;
        }

        public Builder endDate(Date value) {
            this.endDate = value;
            return this;
        }

        public Builder facility(String value) {
            this.facility = value;
            return this;
        }

        public Builder firstName(String value) {
            this.firstName = value;
            return this;
        }

        public Builder lastName(String value) {
            this.lastName = value;
            return this;
        }

        public Builder personId(String value) {
            this.personId = value;
            return this;
        }

        public Builder startDate(Date value) {
            this.startDate = value;
            return this;
        }

        public Builder substrict(String value) {
            this.substrict = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Report build() {
            return new Report(this);
        }

    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseTopic() {
        return courseTopic;
    }

    public String getVenue() {
        return venue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPersonId() {
        return personId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFacility() {
        return facility;
    }

    public String getCity() {
        return city;
    }

    public String getSubstrict() {
        return substrict;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
