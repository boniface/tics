/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.demographics;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.demographics.TitleService;

/**
 *
 * @author geek
 */
public class TitleFacade {

    private final static SpringContext ctx = new SpringContext();

    public static TitleService getTitleService() {
        return ctx.getBean(TitleService.class);
    }
}
