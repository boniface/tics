/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.app.facade.training.course;

import zm.hashcode.tics.app.conf.SpringContext;
import zm.hashcode.tics.services.training.course.CategoryService;

/**
 *
 * @author geek
 */
public class CategoryFacade {

    private final static SpringContext ctx = new SpringContext();

    public static CategoryService getCategoryService() {
        return ctx.getBean(CategoryService.class);
    }
}
