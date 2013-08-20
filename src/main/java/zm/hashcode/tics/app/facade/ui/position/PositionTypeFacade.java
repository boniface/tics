/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.position;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.position.PositionTypeService;

/**
 *
 * @author geek
 */
public class PositionTypeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static PositionTypeService getPositionTypeService() {
        return ctx.getBean(PositionTypeService.class);
    }
}
