/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.training.course.model.ScheduledCourseBean;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author geek
 */
public class ScheduledCourseUtil {

    public ScheduledCourseBean getBean(ScheduledCourse scheduledCourse) {
        ScheduledCourseBean bean = new ScheduledCourseBean();
        bean.setId(scheduledCourse.getId());
        bean.setCourseCapacity(scheduledCourse.getCourseCapacity());
        bean.setCreditHours(scheduledCourse.getCreditHours());
        bean.setEndDate(scheduledCourse.getEndDate());
        bean.setNotes(scheduledCourse.getNotes());
        bean.setStartDate(scheduledCourse.getStartDate());
        bean.setVenue(scheduledCourse.getVenue());
        // for Entities
        bean.setCourseId(scheduledCourse.getCourse().getId());
        bean.setLocationId(scheduledCourse.getLocation().getId());
        // for List or Set
        bean.setFundersIds(getFunderIds(scheduledCourse.getCourseFunders()));
//        bean.setPersonsIds(getPersonsIds(scheduledCourse.getParticipants()));
        bean.setTrainingInstructorsIds(getTrainingInstructorsIds(scheduledCourse.getClassInstructors()));
//
//        // FOR EMBEDDABLES
//        bean.setContactNumber(funder.getContact().getContactNumber());
//        bean.setEmailAddress(funder.getContact().getEmailAddress());
//        bean.setPhysicalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalCode(funder.getContact().getPostalCode());

        return bean;
    }

    public Set<String> getFunderIds(List<Funder> funders) {
        Set<String> ids = new HashSet<>();
        for (Funder uFunder : funders) {
            ids.add(uFunder.getId());
        }
        return ids;

    }

//    public Set<String> getPersonsIds(Set<Person> persons) {
//        Set<String> ids = new HashSet<>();
//        for (Person uPerson : persons) {
//            ids.add(uPerson.getId());
//        }
//        return ids;
//
//    }
    public Set<String> getTrainingInstructorsIds(List<TrainingInstructors> trainingInstructors) {
        Set<String> ids = new HashSet<>();
        for (TrainingInstructors uTrainingInstructors : trainingInstructors) {
            ids.add(uTrainingInstructors.getId());
        }
        return ids;

    }
}
