/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.user;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.demographics.RoleService;
import zm.hashcode.tics.services.users.UserService;

/**
 *
 * @author boniface
 */
public class UserFacade {

    private final static SpringContext ctx = new SpringContext();

    public static UserService getUserService() {
        return ctx.getBean(UserService.class);
    }

    public static RoleService getRoleService() {
        return ctx.getBean(RoleService.class);
    }
}
