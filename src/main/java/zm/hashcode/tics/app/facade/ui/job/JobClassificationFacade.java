/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.job;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.job.JobClassificationService;

/**
 *
 * @author geek
 */
public class JobClassificationFacade {

    private final static SpringContext ctx = new SpringContext();

    public static JobClassificationService getJobClassificationService() {
        return ctx.getBean(JobClassificationService.class);
    }
}
