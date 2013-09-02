/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.mentoring;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.mentoring.MentorsService;

/**
 *
 * @author geek
 */
public class MentorsFacade {

    private final static SpringContext ctx = new SpringContext();

    public static MentorsService getMentorsService() {
        return ctx.getBean(MentorsService.class);
    }
}
