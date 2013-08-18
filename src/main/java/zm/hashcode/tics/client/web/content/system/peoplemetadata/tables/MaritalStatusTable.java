/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.MaritalStatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.MaritalStatus;

/**
 *
 * @author geek
 */
public class MaritalStatusTable extends Table {

    private final TicsMain main;

    public MaritalStatusTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Status Name", String.class, null);
        List<MaritalStatus> maritalStatuses = MaritalStatusFacade.getMaritalStatusService().findAll();
        for (MaritalStatus iMaritalStatus : maritalStatuses) {
            addItem(new Object[]{iMaritalStatus.getStatusName()
            }, iMaritalStatus.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
