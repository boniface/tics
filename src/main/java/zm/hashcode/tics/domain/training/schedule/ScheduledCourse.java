/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.schedule;

import zm.hashcode.tics.domain.training.course.Course;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author boniface
 */
@Document
public final class ScheduledCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String venue;
    private String notes;
    private int courseCapacity;
    private int creditHours;
    private Date startDate;
    private Date endDate;
    @DBRef
    private Course course;
    @DBRef
    private Location location;
    @DBRef
    private Set<Person> participants = new HashSet<>();
    @DBRef
    private List<TrainingInstructors> classInstructors = new ArrayList();
    @DBRef
    private List<Funder> courseFunders = new ArrayList();
    List<CourseRating> courseRatings = new ArrayList();

    private ScheduledCourse() {
    }

    private ScheduledCourse(Builder builder) {
        id = builder.id;
        venue = builder.venue;
        notes = builder.notes;
        courseCapacity = builder.courseCapacity;
        creditHours = builder.creditHours;
        startDate = builder.startDate;
        endDate = builder.endDate;
        course = builder.course;
        location = builder.location;
        participants = builder.participants;
        classInstructors = builder.classInstructors;
        courseFunders = builder.courseFunders;
        courseRatings = builder.courseRatings;

    }

    public static class Builder {

        private String id;
        private String venue;
        private String notes;
        private int courseCapacity;
        private int creditHours;
        private Date startDate;
        private Date endDate;
        private final Course course;
        private Location location;
        private Set<Person> participants;
        private List<TrainingInstructors> classInstructors;
        private List<Funder> courseFunders;
        List<CourseRating> courseRatings;

        public Builder(Course val) {
            this.course = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder venue(String value) {
            venue = value;
            return this;
        }

        public Builder notes(String value) {
            notes = value;
            return this;
        }

        public Builder courseCapacity(int value) {
            courseCapacity = value;
            return this;
        }

        public Builder creditHours(int value) {
            creditHours = value;
            return this;
        }

        public Builder startDate(Date value) {
            startDate = value;
            return this;
        }

        public Builder endDate(Date value) {
            endDate = value;
            return this;
        }

        public Builder location(Location value) {
            location = value;
            return this;
        }

        public Builder courseFunders(List<Funder> value) {
            courseFunders = value;
            return this;
        }

        public Builder participants(Set<Person> value) {
            participants = value;
            return this;
        }

        public Builder courseRatings(List<CourseRating> value) {
            courseRatings = value;
            return this;
        }

        public Builder classInstructors(List<TrainingInstructors> value) {
            classInstructors = value;
            return this;
        }

        public Builder scheduledCourse(ScheduledCourse scheduledCourse) {
            id = scheduledCourse.getId();
            venue = scheduledCourse.getVenue();
            notes = scheduledCourse.getNotes();
            courseCapacity = scheduledCourse.getCourseCapacity();
            creditHours = scheduledCourse.getCreditHours();
            startDate = scheduledCourse.getStartDate();
            endDate = scheduledCourse.getEndDate();
            location = scheduledCourse.getLocation();
            participants = scheduledCourse.getParticipants();
            classInstructors = scheduledCourse.getClassInstructors();
            courseFunders = scheduledCourse.getCourseFunders();
            courseRatings = scheduledCourse.getCourseRatings();
            return this;
        }

        public ScheduledCourse build() {
            return new ScheduledCourse(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getVenue() {
        return venue;
    }

    public String getNotes() {
        return notes;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Course getCourse() {
        return course;
    }

    public Location getLocation() {
        return location;
    }

    public Set<Person> getParticipants() {
        return participants;
    }

    public List<TrainingInstructors> getClassInstructors() {
        return classInstructors;
    }

    public List<Funder> getCourseFunders() {
        return courseFunders;
    }

    public List<CourseRating> getCourseRatings() {
        return courseRatings;
    }

    @Override
    public String toString() {
        return "ScheduledCourse{" + "id=" + id + ", venue=" + venue + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final ScheduledCourse other = (ScheduledCourse) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
