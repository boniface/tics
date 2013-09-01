/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.people;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.people.EmployeeActionPlanService;
import zm.hashcode.tics.services.people.EmployeeCoursesService;
import zm.hashcode.tics.services.people.EmployeeMentoringService;
import zm.hashcode.tics.services.people.PersonService;

/**
 *
 * @author geek
 */
public class PersonFacade {

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
}
