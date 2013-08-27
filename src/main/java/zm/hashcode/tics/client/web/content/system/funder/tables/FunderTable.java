/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.util.FunderFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author geek
 */
public class FunderTable extends Table {

    private final TicsMain main;

    public FunderTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Funder Name", String.class, null);
        addContainerProperty("City", String.class, null);
        addContainerProperty("Course Center", String.class, null);
        List<Funder> funders = FunderFacade.getFunderService().findAll();
        for (Funder iFunder : funders) {
            addItem(new Object[]{iFunder.getTrainingFunderName(),
                iFunder.getCity().getName(),
                iFunder.getCourseCenter()
            }, iFunder.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
