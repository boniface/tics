/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.training.course.model.CourseBean;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.domain.training.course.Category;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.course.CourseType;
import zm.hashcode.tics.domain.training.course.Criteria;
import zm.hashcode.tics.domain.training.course.TargetGroup;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class CourseUtil {

    public CourseBean getBean(Course course) {
        CourseBean bean = new CourseBean();
        bean.setId(course.getId());
        bean.setCourseObjective(course.getCourseObjective());
        bean.setCourseTopic(course.getCourseTopic());
        bean.setName(course.getName());
        bean.setNotes(course.getNotes());
        // for Entities
        bean.setCourseCategoryId(getCourseCategoryId(course.getCourseCategory()));
        bean.setCourseCriteriaId(getCriteriaId(course.getCourseCriteria()));
        bean.setCourseStatusId(getCourseStatusId(course.getCourseStatus()));
        bean.setCourseTypeId(getCourseTypeId(course.getCourseType()));
        bean.setInstitutionNameId(getInstitutionNameId(course.getInstitutionName()));

        // for List or Set
        bean.setCourseCompetenciesIds(getCourseCompetencyIds(course.getCourseCompetencies()));
        bean.setCourseTargetGroupIds(getTargetGroupIds(course.getCourseTargetGroup()));
//
//        // FOR EMBEDDABLES
//        bean.setContactNumber(funder.getContact().getContactNumber());
//        bean.setEmailAddress(funder.getContact().getEmailAddress());
//        bean.setPhysicalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalCode(funder.getContact().getPostalCode());

        return bean;
    }

    public String getCourseCategoryId(Category category) {
        return category.getId();
    }

    public String getCriteriaId(Criteria criteria) {
        return criteria.getId();
    }

    public String getCourseStatusId(Status status) {
        return status.getId();
    }

    public String getCourseTypeId(CourseType courseType) {
        return courseType.getId();
    }

    public String getInstitutionNameId(TrainingInstitution trainingInstitution) {
        return trainingInstitution.getId();
    }

    public Set<String> getCourseCompetencyIds(List<Competency> competencies) {
        Set<String> ids = new HashSet<>();
        for (Competency iCompetency : competencies) {
            ids.add(iCompetency.getId());
        }
        return ids;

    }

    public Set<String> getTargetGroupIds(List<TargetGroup> targetGroup) {
        Set<String> ids = new HashSet<>();
        for (TargetGroup iTargetGroup : targetGroup) {
            ids.add(iTargetGroup.getId());
        }
        return ids;

    }
}
