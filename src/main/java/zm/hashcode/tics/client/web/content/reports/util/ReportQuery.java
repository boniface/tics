/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author boniface
 */
public class ReportQuery implements Serializable {

    private Date startDate;
    private Date endDate;
    private String facilityId;
    private String locationTypeId;
    private String locationId;
    private String courseId;
    private String professionId;

    private ReportQuery(Builder builder) {
        startDate = builder.startDate;
        endDate = builder.endDate;
        locationTypeId = builder.locationTypeId;
        facilityId = builder.facilityId;
        locationId = builder.locationId;
        courseId = builder.courseId;
        professionId = builder.professionId;
    }

    public static class Builder {

        private Date startDate;
        private Date endDate;
        // Optional
        private String facilityId;
        private String locationTypeId;
        private String locationId;
        private String courseId;
        private String professionId;

        public Builder(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Builder facilityId(String value) {
            facilityId = value;
            return this;
        }

        public Builder locationTypeId(String value) {
            locationTypeId = value;
            return this;
        }

        public Builder locationId(String value) {
            locationId = value;
            return this;
        }

        public Builder courseId(String value) {
            courseId = value;
            return this;
        }

        public Builder professionId(String value) {
            professionId = value;
            return this;
        }

        public ReportQuery build() {
            return new ReportQuery(this);
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getLocationTypeId() {
        return locationTypeId;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getProfessionId() {
        return professionId;
    }
}
