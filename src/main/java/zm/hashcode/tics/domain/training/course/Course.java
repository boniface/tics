/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.course;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */
@Document
public class Course implements Serializable, Comparable<Course> {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    @DBRef
    private Category courseCategory;
    private String courseTopic;
    @DBRef
    private TrainingInstitution institutionName;
    @DBRef
    private Status courseStatus;
    private String courseObjective;
    @DBRef
    private CourseType courseType;
    @DBRef
    private List<Competency> courseCompetencies;
    @DBRef
    private List<TargetGroup> courseTargetGroup;
    @DBRef
    private Criteria courseCriteria;
    private String notes;

    private Course() {
    }

    private Course(Builder builder) {
        id = builder.id;
        name = builder.name;
        courseCategory = builder.courseCategory;
        courseCompetencies = builder.courseCompetencies;
        courseTopic = builder.courseTopic;
        institutionName = builder.institutionName;
        courseStatus = builder.courseStatus;
        courseObjective = builder.courseObjective;
        courseType = builder.courseType;
        courseTargetGroup = builder.courseTargetGroup;
        courseCriteria = builder.courseCriteria;
        notes = builder.notes;

    }

    public static class Builder {

        private String id;
        private final String name;
        private String courseObjective;
        private String notes;
        private String courseTopic;
        private Category courseCategory;
        private TrainingInstitution institutionName;
        private Status courseStatus;
        private Criteria courseCriteria;
        private CourseType courseType;
        private List<Competency> courseCompetencies;
        private List<TargetGroup> courseTargetGroup;

        public Builder(String val) {
            this.name = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder notes(String value) {
            notes = value;
            return this;
        }

        public Builder courseObjective(String value) {
            courseObjective = value;
            return this;
        }

        public Builder courseTopic(String value) {
            courseTopic = value;
            return this;
        }

        public Builder courseCategory(Category value) {
            courseCategory = value;
            return this;
        }

        public Builder institutionName(TrainingInstitution value) {
            institutionName = value;
            return this;
        }

        public Builder courseStatus(Status value) {
            courseStatus = value;
            return this;
        }

        public Builder courseCriteria(Criteria value) {
            courseCriteria = value;
            return this;
        }

        public Builder courseType(CourseType value) {
            courseType = value;
            return this;
        }

        public Builder courseCompetencies(List<Competency> value) {
            courseCompetencies = value;
            return this;
        }

        public Builder courseTargetGroup(List<TargetGroup> value) {
            courseTargetGroup = value;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }

    @Override
    public int compareTo(Course o) {
        return name.compareTo(o.name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCourseCategory() {
        return courseCategory;
    }

    public String getCourseTopic() {
        return courseTopic;
    }

    public TrainingInstitution getInstitutionName() {
        return institutionName;
    }

    public Status getCourseStatus() {
        return courseStatus;
    }

    public String getCourseObjective() {
        return courseObjective;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public List<Competency> getCourseCompetencies() {
        return ImmutableList.copyOf(courseCompetencies);
    }

    public List<TargetGroup> getCourseTargetGroup() {
        return ImmutableList.copyOf(courseTargetGroup);
    }

    public Criteria getCourseCriteria() {
        return courseCriteria;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
