/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.people;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.services.people.EmployeeActionPlanService;
import zm.hashcode.tics.services.people.EmployeeCoursesService;
import zm.hashcode.tics.services.people.EmployeeMentoringService;
import zm.hashcode.tics.services.people.PersonService;
import zm.hashcode.tics.services.people.predicates.PeoplePredicate;

/**
 *
 * @author geek
 */
public class PersonFacade {

    private static GetUserCredentials creds = new GetUserCredentials();
    private final static SpringContext ctx = new SpringContext();

    public static PersonService getPersonService() {
        return ctx.getBean(PersonService.class);
    }

    public static EmployeeActionPlanService getEmployeeActionPlanService() {
        return ctx.getBean(EmployeeActionPlanService.class);
    }

    public static EmployeeMentoringService getEmployeeMentoringService() {
        return ctx.getBean(EmployeeMentoringService.class);
    }

    public static EmployeeCoursesService getEmployeeCoursesService() {
        return ctx.getBean(EmployeeCoursesService.class);
    }

    public static List<Person> getPeople() {
        User user = creds.getLoggedInUser();
        List<Person> allpeople = getPersonService().findAll();
        if (user.getJusridication().isEmpty()) {
            return allpeople;
        } else {
            Collection<Person> people = Collections2.filter(allpeople, new PeoplePredicate());
            return ImmutableList.copyOf(people);
        }

    }
}
