/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.course;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.course.TargetGroupService;

/**
 *
 * @author geek
 */
public class TargetGroupFacade {

    private final static SpringContext ctx = new SpringContext();

    public static TargetGroupService getTargetGroupService() {
        return ctx.getBean(TargetGroupService.class);
    }
}
