/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.mentoring;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.mentoring.MentoringSessionService;

/**
 *
 * @author geek
 */
public class MentoringSessionFacade {

    private final static SpringContext ctx = new SpringContext();

    public static MentoringSessionService getMentoringSessionService() {
        return ctx.getBean(MentoringSessionService.class);
    }
}
