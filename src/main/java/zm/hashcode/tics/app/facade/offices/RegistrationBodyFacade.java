/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.offices;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.offices.RegistrationBodyService;

/**
 *
 * @author geek
 */
public class RegistrationBodyFacade {

    private final static SpringContext ctx = new SpringContext();

    public static RegistrationBodyService getRegistrationBodyService() {
        return ctx.getBean(RegistrationBodyService.class);
    }
}
