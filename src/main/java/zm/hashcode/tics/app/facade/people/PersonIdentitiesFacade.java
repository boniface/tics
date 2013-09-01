/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.people;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.people.PersonIdentitiesService;

/**
 *
 * @author geek
 */
public class PersonIdentitiesFacade {

    private final static SpringContext ctx = new SpringContext();

    public static PersonIdentitiesService getPersonIdentitiesService() {
        return ctx.getBean(PersonIdentitiesService.class);
    }
}
