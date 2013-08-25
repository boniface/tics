/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class StatusTable extends Table {

    private final TicsMain main;

    public StatusTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Status Type", String.class, null);
        addContainerProperty("Status Value", String.class, null);

        List<Status> status = StatusFacade.getStatusService().findAll();
        for (Status iStatus : status) {
            addItem(new Object[]{iStatus.getStatusType(),
                iStatus.getStatusValue()
            }, iStatus.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
