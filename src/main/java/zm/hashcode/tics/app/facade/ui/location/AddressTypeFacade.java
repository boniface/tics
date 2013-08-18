/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.location;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.location.AddressTypeService;

/**
 *
 * @author geek
 */
public class AddressTypeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static AddressTypeService getAddressTypeService() {
        return ctx.getBean(AddressTypeService.class);
    }
}
