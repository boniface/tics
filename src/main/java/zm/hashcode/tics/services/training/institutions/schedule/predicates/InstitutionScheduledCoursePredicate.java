/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.schedule.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.client.web.content.training.institutions.util.TrainingInstructorUtil;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author boniface
 */
public class InstitutionScheduledCoursePredicate implements Predicate<ScheduledCourse> {

    TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();

    @Override
    public boolean apply(ScheduledCourse course) {
        if (course.getCourse().getInstitutionName().equals(trainingInstitution)) {
            return true;
        }
        return false;
    }
}
