/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.mentoring;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.mentoring.MentoringThemeService;

/**
 *
 * @author geek
 */
public class MentoringThemeFacade {

    private final static SpringContext ctx = new SpringContext();

    public static MentoringThemeService getMentoringThemeService() {
        return ctx.getBean(MentoringThemeService.class);
    }
}
