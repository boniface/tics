/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.traininginstitution.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.system.traininginstitution.model.TrainingInstitutionBean;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author geek
 */
public class TrainingInstitutionUtil {

    public TrainingInstitutionBean getBean(TrainingInstitution trainingInstitution) {
        TrainingInstitutionBean bean = new TrainingInstitutionBean();
        bean.setId(trainingInstitution.getId());
        bean.setName(trainingInstitution.getName());
        bean.setCoursesIds(getCourseIdz(trainingInstitution.getCourses()));
        bean.setLocationId(getLocationId(trainingInstitution.getCity()));
        bean.setScheduledCoursesIds(getScheduledCoursesIdz(trainingInstitution.getScheduledCourses()));
        bean.setTrainingInstructorsIds(getTrainingInstructorsIdz(trainingInstitution.getTrainingInstructors()));
        bean.setUsersIds(getUserIdz(trainingInstitution.getUsers()));

        return bean;
    }

    public Set<String> getCourseIdz(List<Course> courses) {
        Set<String> ids = new HashSet<>();
        for (Course iCourse : courses) {
            ids.add(iCourse.getId());
        }
        return ids;
    }

    public Set<String> getScheduledCoursesIdz(List<ScheduledCourse> scheduledCourse) {
        Set<String> ids = new HashSet<>();
        for (ScheduledCourse iScheduledCourse : scheduledCourse) {
            ids.add(iScheduledCourse.getId());
        }
        return ids;
    }

    public Set<String> getTrainingInstructorsIdz(List<TrainingInstructors> trainingInstructors) {
        Set<String> ids = new HashSet<>();
        for (TrainingInstructors iTrainingInstructors : trainingInstructors) {
            ids.add(iTrainingInstructors.getId());
        }
        return ids;
    }

    public Set<String> getUserIdz(List<User> users) {
        Set<String> ids = new HashSet<>();
        for (User iUsers : users) {
            ids.add(iUsers.getId());
        }
        return ids;
    }

    public String getLocationId(Location location) {
        return location.getId();
    }
}
