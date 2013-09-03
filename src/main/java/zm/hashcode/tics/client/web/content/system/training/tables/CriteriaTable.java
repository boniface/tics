/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.training.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CriteriaFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.course.Criteria;

/**
 *
 * @author geek
 */
public class CriteriaTable extends Table {

    private final TicsMain main;

    public CriteriaTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);

        List<Criteria> criterias = CriteriaFacade.getCriteriaService().findAll();
        for (Criteria iCriteria : criterias) {
            addItem(new Object[]{iCriteria.getName()
            }, iCriteria.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
