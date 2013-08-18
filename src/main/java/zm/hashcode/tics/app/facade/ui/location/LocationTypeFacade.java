/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.location;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.location.LocationTypeService;

/**
 *
 * @author geek
 */
public class LocationTypeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static LocationTypeService getLocationTypeService() {
        return ctx.getBean(LocationTypeService.class);
    }
}
