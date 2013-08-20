/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.people;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.people.PersonService;

/**
 *
 * @author geek
 */
public class PersonFacade {

    private final static SpringContext ctx = new SpringContext();

    public static PersonService getPersonService() {
        return ctx.getBean(PersonService.class);
    }
}
