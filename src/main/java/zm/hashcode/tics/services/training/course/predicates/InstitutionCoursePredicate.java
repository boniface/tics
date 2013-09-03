/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.client.web.content.training.institutions.util.TrainingInstructorUtil;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;

/**
 *
 * @author boniface
 */
public class InstitutionCoursePredicate implements Predicate<Course> {

    TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();

    @Override
    public boolean apply(Course course) {
        if (course.getInstitutionName().equals(trainingInstitution)) {
            return true;
        }
        return false;
    }
}
