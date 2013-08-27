/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.course;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.course.CriteriaService;

/**
 *
 * @author geek
 */
public class CriteriaFacade {

    private final static SpringContext ctx = new SpringContext();

    public static CriteriaService getCriteriaService() {
        return ctx.getBean(CriteriaService.class);
    }
}
