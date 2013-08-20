/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.util;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.util.StatusService;

/**
 *
 * @author geek
 */
public class StatusFacade {

    private final static SpringContext ctx = new SpringContext();

    public static StatusService getStatusService() {
        return ctx.getBean(StatusService.class);
    }
}
