/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.people;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.training.TrainingCourseRequestors;
import zm.hashcode.tics.domain.training.Course;

/**
 *
 * @author boniface
 */
@Document
public final class EmployeeCourses implements Serializable {

    private static long serialVersionUID = 1L;
    private String id;
    private Date dateRequested;
    private String retraining;
    private String trainingStatus;
    private TrainingCourseRequestors requestor;
    private Date lastEvaluated;
    private String competencyName;
    private String competencyNotes;
    private Date courseStartDate;
    private Date courseEndDate;
    @DBRef
    private Course course;
    private String scheduledCourseSessionId;

    private EmployeeCourses() {
    }

    private EmployeeCourses(Builder builder) {
        id = builder.id;
        dateRequested = builder.dateRequested;
        retraining = builder.retraining;
        trainingStatus = builder.trainingStatus;
        requestor = builder.requestor;
        lastEvaluated = builder.lastEvaluated;
        competencyName = builder.competencyName;
        competencyNotes = builder.competencyNotes;
        courseStartDate = builder.courseStartDate;
        courseEndDate = builder.courseEndDate;
        course = builder.course;
        scheduledCourseSessionId = builder.scheduledCourseSessionId;

    }

    public static class Builder {

        private String id;
        private Date dateRequested;
        private String retraining;
        private String trainingStatus;
        private TrainingCourseRequestors requestor;
        private Date lastEvaluated;
        private String competencyName;
        private String competencyNotes;
        private Date courseStartDate;
        private Date courseEndDate;
        private final Course course;
        private String scheduledCourseSessionId;

        public Builder(Course val) {
            this.course = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder trainingStatus(String value) {
            trainingStatus = value;
            return this;
        }

        public Builder competencyName(String value) {
            competencyName = value;
            return this;
        }

        public Builder competencyNotes(String value) {
            competencyNotes = value;
            return this;
        }

        public Builder scheduledCourseSessionId(String value) {
            scheduledCourseSessionId = value;
            return this;
        }

        public Builder requestor(TrainingCourseRequestors value) {
            requestor = value;
            return this;
        }

        public Builder retraining(String value) {
            retraining = value;
            return this;
        }

        public Builder dateRequested(Date value) {
            dateRequested = value;
            return this;
        }

        public Builder lastEvaluated(Date value) {
            lastEvaluated = value;
            return this;
        }

        public Builder courseStartDate(Date value) {
            courseStartDate = value;
            return this;
        }

        public Builder courseEndDate(Date value) {
            courseEndDate = value;
            return this;
        }

        public EmployeeCourses build() {
            return new EmployeeCourses(this);
        }
    }

    @Override
    public String toString() {
        return "EmployeeCourses{" + "id=" + id + ", courseEndDate=" + courseEndDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final EmployeeCourses other = (EmployeeCourses) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public String getRetraining() {
        return retraining;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public TrainingCourseRequestors getRequestor() {
        return requestor;
    }

    public Date getLastEvaluated() {
        return lastEvaluated;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public String getCompetencyNotes() {
        return competencyNotes;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public Course getCourse() {
        return course;
    }

    public String getScheduledCourseSessionId() {
        return scheduledCourseSessionId;
    }
    
}
