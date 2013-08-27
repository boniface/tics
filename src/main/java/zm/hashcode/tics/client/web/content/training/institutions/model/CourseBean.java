/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.model;

import java.io.Serializable;
import java.util.Set;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.course.TargetGroup;

/**
 *
 * @author geek
 */
public class CourseBean implements Serializable {

    private String id;
    private String name;
    private String courseCategoryId;
    private String courseTopic;
    private String institutionNameId;
    private String courseStatusId;
    private String courseObjective;
    private String courseTypeId;
    private Set<String> courseCompetenciesIds;
    private Set<String> courseTargetGroupIds;
    private String courseCriteriaId;
    private String notes;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the courseCategoryId
     */
    public String getCourseCategoryId() {
        return courseCategoryId;
    }

    /**
     * @param courseCategoryId the courseCategoryId to set
     */
    public void setCourseCategoryId(String courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
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
     * @return the institutionNameId
     */
    public String getInstitutionNameId() {
        return institutionNameId;
    }

    /**
     * @param institutionNameId the institutionNameId to set
     */
    public void setInstitutionNameId(String institutionNameId) {
        this.institutionNameId = institutionNameId;
    }

    /**
     * @return the courseStatusId
     */
    public String getCourseStatusId() {
        return courseStatusId;
    }

    /**
     * @param courseStatusId the courseStatusId to set
     */
    public void setCourseStatusId(String courseStatusId) {
        this.courseStatusId = courseStatusId;
    }

    /**
     * @return the courseObjective
     */
    public String getCourseObjective() {
        return courseObjective;
    }

    /**
     * @param courseObjective the courseObjective to set
     */
    public void setCourseObjective(String courseObjective) {
        this.courseObjective = courseObjective;
    }

    /**
     * @return the courseTypeId
     */
    public String getCourseTypeId() {
        return courseTypeId;
    }

    /**
     * @param courseTypeId the courseTypeId to set
     */
    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    /**
     * @return the courseCriteriaId
     */
    public String getCourseCriteriaId() {
        return courseCriteriaId;
    }

    /**
     * @param courseCriteriaId the courseCriteriaId to set
     */
    public void setCourseCriteriaId(String courseCriteriaId) {
        this.courseCriteriaId = courseCriteriaId;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the courseCompetenciesIds
     */
    public Set<String> getCourseCompetenciesIds() {
        return courseCompetenciesIds;
    }

    /**
     * @param courseCompetenciesIds the courseCompetenciesIds to set
     */
    public void setCourseCompetenciesIds(Set<String> courseCompetenciesIds) {
        this.courseCompetenciesIds = courseCompetenciesIds;
    }

    /**
     * @return the courseTargetGroupIds
     */
    public Set<String> getCourseTargetGroupIds() {
        return courseTargetGroupIds;
    }

    /**
     * @param courseTargetGroupIds the courseTargetGroupIds to set
     */
    public void setCourseTargetGroupIds(Set<String> courseTargetGroupIds) {
        this.courseTargetGroupIds = courseTargetGroupIds;
    }
}
