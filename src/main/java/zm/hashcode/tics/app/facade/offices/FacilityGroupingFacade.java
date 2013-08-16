/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.offices;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.offices.FacilityGroupingService;

/**
 *
 * @author ColinWa
 */
public class FacilityGroupingFacade {

    private final static SpringContext ctx = new SpringContext();

    public static FacilityGroupingService getFacilityGroupingService() {
        return ctx.getBean(FacilityGroupingService.class);
    }
}
