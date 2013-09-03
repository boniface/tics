/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.mentoring;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.mentoring.MentoringSubjectAreaService;

/**
 *
 * @author geek
 */
public class MentoringSubjectAreaFacade {

    private final static SpringContext ctx = new SpringContext();

    public static MentoringSubjectAreaService getMentoringSubjectAreaService() {
        return ctx.getBean(MentoringSubjectAreaService.class);
    }
}
