/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author boniface
 */
public class CourseStatusPredicate implements Predicate<Status> {

    @Override
    public boolean apply(Status status) {
        if (status.getStatusType().equals("COURSE")) {
            return true;
        }
        return false;
    }
}
