/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.position;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.position.PositionService;

/**
 *
 * @author geek
 */
public class PositionFacade {

    private final static SpringContext ctx = new SpringContext();

    public static PositionService getPositionService() {
        return ctx.getBean(PositionService.class);
    }
}
