/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.competencies;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.competencies.CompetencyService;

/**
 *
 * @author geek
 */
public class CompetencyFacade {

    private final static SpringContext ctx = new SpringContext();

    public static CompetencyService getCompetencyService() {
        return ctx.getBean(CompetencyService.class);
    }
}
