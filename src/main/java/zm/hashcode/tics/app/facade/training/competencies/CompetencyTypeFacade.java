/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.competencies;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.competencies.CompetencyTypeService;

/**
 *
 * @author geek
 */
public class CompetencyTypeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static CompetencyTypeService getCompetencyTypeService() {
        return ctx.getBean(CompetencyTypeService.class);
    }
}
