/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.ui.demographics;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.ui.demographics.LanguageService;

/**
 *
 * @author geek
 */
public class LanguageFacade {

    private final static SpringContext ctx = new SpringContext();

    public static LanguageService getLanguageService() {
        return ctx.getBean(LanguageService.class);
    }
}
