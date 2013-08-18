/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.demographics;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.demographics.IdentificationTypeService;

/**
 *
 * @author geek
 */
public class IdentificationTypeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static IdentificationTypeService getIdentificationTypeService() {
        return ctx.getBean(IdentificationTypeService.class);
    }
}
