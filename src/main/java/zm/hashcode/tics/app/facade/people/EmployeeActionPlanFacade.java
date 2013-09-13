/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.people;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.people.EmployeeActionPlanService;

/**
 *
 * @author geek
 */
public class EmployeeActionPlanFacade {

    private final static SpringContext ctx = new SpringContext();

    public static EmployeeActionPlanService getEmployeeActionPlanService() {
        return ctx.getBean(EmployeeActionPlanService.class);
    }
}
