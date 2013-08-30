/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CategoryFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.course.Category;

/**
 *
 * @author geek
 */
public class CategoryTable extends Table {

    private final TicsMain main;

    public CategoryTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);

        List<Category> categories = CategoryFacade.getCategoryService().findAll();
        for (Category category : categories) {
            addItem(new Object[]{category.getName(),}, category.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
