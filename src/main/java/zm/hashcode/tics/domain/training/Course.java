/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */
@Document
public class Course implements Serializable,Comparable<Course> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String courseName;

    private TrainingCourseCategory courseCategory;
    private String courseTopic;
 
    private TrainingInstitution institutionName;

    private Status courseStatus;
    private String courseObjective;
   
    private CourseTypeName courseType;

    private List<CourseFunders> courseFunders = new ArrayList<>();

    private List<CourseCompetencies> courseCompetencies = new ArrayList<>();
    

    private List<CourseTargetGroup> courseTargetGroup= new ArrayList<>();
    
    private CourseCriteria courseCriteria;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashthrims.domain.traininglist.TrainingCourses[id=" + id + "]";
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseTopic
     */
    public String getCourseTopic() {
        return courseTopic;
    }

    /**
     * @param courseTopic the courseTopic to set
     */
    public void setCourseTopic(String courseTopic) {
        this.courseTopic = courseTopic;
    }

    /**
     * @return the courseNotes
     */
    public String getCourseObjectives() {
        return courseObjective;
    }

    /**
     * @param courseNotes the courseNotes to set
     */
    public void setCourseObjectives(String objective) {
        this.courseObjective = objective;
    }

    /**
     * @return the courseCategory
     */
    public TrainingCourseCategory getCourseCategory() {
        return courseCategory;
    }

    /**
     * @param courseCategory the courseCategory to set
     */
    public void setCourseCategory(TrainingCourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    /**
     * @return the institutionName
     */
    public TrainingInstitution getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName the institutionName to set
     */
    public void setInstitutionName(TrainingInstitution institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * @return the courseStatus
     */
    public Status getCourseStatus() {
        return courseStatus;
    }

    /**
     * @param courseStatus the courseStatus to set
     */
    public void setCourseStatus(Status courseStatus) {
        this.courseStatus = courseStatus;
    }

    /**
     * @return the courseType
     */
    public CourseTypeName getCourseType() {
        return courseType;
    }

    /**
     * @param courseType the courseType to set
     */
    public void setCourseType(CourseTypeName courseType) {
        this.courseType = courseType;
    }

    /**
     * @return the courseCompetencies
     */
    public List<CourseCompetencies> getCourseCompetencies() {
        return courseCompetencies;
    }

    /**
     * @param courseCompetencies the courseCompetencies to set
     */
    public void setCourseCompetencies(List<CourseCompetencies> courseCompetencies) {
        this.courseCompetencies = courseCompetencies;
    }

    /**
     * @return the courseFunders
     */
    public List<CourseFunders> getCourseFunders() {
        return courseFunders;
    }

    /**
     * @param courseFunders the courseFunders to set
     */
    public void setCourseFunders(List<CourseFunders> courseFunders) {
        this.courseFunders = courseFunders;
    }

    @Override
    public int compareTo(Course o) {
       return courseName.compareTo(o.courseName);
    }

    /**
     * @return the courseTargetGroup
     */
    public List<CourseTargetGroup> getCourseTargetGroup() {
        return courseTargetGroup;
    }

    /**
     * @param courseTargetGroup the courseTargetGroup to set
     */
    public void setCourseTargetGroup(List<CourseTargetGroup> courseTargetGroup) {
        this.courseTargetGroup = courseTargetGroup;
    }

    /**
     * @return the courseCriteria
     */
    public CourseCriteria getCourseCriteria() {
        return courseCriteria;
    }

    /**
     * @param courseCriteria the courseCriteria to set
     */
    public void setCourseCriteria(CourseCriteria courseCriteria) {
        this.courseCriteria = courseCriteria;
    }

    
}
