/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.institutions;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.institutions.TrainingInstructorsService;

/**
 *
 * @author geek
 */
public class TrainingInstructorsFacade {

    private final static SpringContext ctx = new SpringContext();

    public static TrainingInstructorsService getTrainingInstructorsService() {
        return ctx.getBean(TrainingInstructorsService.class);
    }
}
