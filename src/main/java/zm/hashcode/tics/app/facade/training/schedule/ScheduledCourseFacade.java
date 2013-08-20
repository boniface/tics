/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.schedule;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.institutions.schedule.ScheduledCourseService;

/**
 *
 * @author geek
 */
public class ScheduledCourseFacade {

    private final static SpringContext ctx = new SpringContext();

    public static ScheduledCourseService getScheduledCourseService() {
        return ctx.getBean(ScheduledCourseService.class);
    }
}
