/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.job;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.job.JobService;

/**
 *
 * @author geek
 */
public class JobFacade {

    private final static SpringContext ctx = new SpringContext();

    public static JobService getJobService() {
        return ctx.getBean(JobService.class);
    }
}
