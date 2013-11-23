/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util.predicates;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.domain.people.EmployeePosition;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.services.people.predicates.PersonPositionPredicate;

/**
 *
 * @author boniface
 */
public class PersonProfessionPredicate implements Predicate<Person> {

    private final String professionalId;

    public PersonProfessionPredicate(String professionalId) {
        this.professionalId = professionalId;
    }

    @Override
    public boolean apply(Person person) {
        return professionalId.equalsIgnoreCase(getCurrentPositionId(person.getPositions()));
    }

    private String getCurrentPositionId(List<EmployeePosition> positions) {
        Collection<EmployeePosition> pos = Collections2.filter(positions, new PersonPositionPredicate());
        EmployeePosition employeePosition = pos.iterator().next();
        if (employeePosition != null) {
            return employeePosition.getStatus();
        }
        return null;
    }
}
