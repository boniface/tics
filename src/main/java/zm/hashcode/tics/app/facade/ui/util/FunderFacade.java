/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.util;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.util.FunderService;

/**
 *
 * @author geek
 */
public class FunderFacade {

    private final static SpringContext ctx = new SpringContext();

    public static FunderService getFunderService() {
        return ctx.getBean(FunderService.class);
    }
}
