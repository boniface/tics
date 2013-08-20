/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.position.DepartureReasonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.position.DepartureReason;

/**
 *
 * @author geek
 */
public class DepartureReasonTable extends Table {

    private final TicsMain main;

    public DepartureReasonTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Reason Name", String.class, null);
        addContainerProperty("Description", String.class, null);

        List<DepartureReason> departureReasonlist = DepartureReasonFacade.getDepartureReasonService().findAll();
        for (DepartureReason iDepartureReason : departureReasonlist) {
            addItem(new Object[]{iDepartureReason.getReasonName(),
                iDepartureReason.getDescription()
            }, iDepartureReason.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
