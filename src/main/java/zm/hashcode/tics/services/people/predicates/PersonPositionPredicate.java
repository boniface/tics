/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.predicates;

import com.google.common.base.Predicate;
import zm.hashcode.tics.domain.people.EmployeePosition;

/**
 *
 * @author boniface
 */
public class PersonPositionPredicate implements Predicate<EmployeePosition> {

    @Override
    public boolean apply(EmployeePosition position) {
        return "CURRENT".equalsIgnoreCase(position.getStatus());
    }
}
