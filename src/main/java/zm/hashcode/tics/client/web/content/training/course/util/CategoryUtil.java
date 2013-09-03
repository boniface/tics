/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.util;

import zm.hashcode.tics.client.web.content.system.training.model.CategoryBean;
import zm.hashcode.tics.domain.training.course.Category;

/**
 *
 * @author geek
 */
public class CategoryUtil {

    public CategoryBean getBean(Category category) {
        CategoryBean bean = new CategoryBean();
        bean.setId(category.getId());
        bean.setName(category.getName());
        return bean;
    }
}
