/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.competencies;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.competencies.EvaluationService;

/**
 *
 * @author geek
 */
public class EvaluationFacade {

    private final static SpringContext ctx = new SpringContext();

    public static EvaluationService getEvaluationService() {
        return ctx.getBean(EvaluationService.class);
    }
}
