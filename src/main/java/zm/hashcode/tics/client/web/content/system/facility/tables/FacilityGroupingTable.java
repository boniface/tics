/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityGroupingFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.FacilityGrouping;

/**
 *
 * @author ColinWa
 */
public class FacilityGroupingTable extends Table {

    private final TicsMain main;

    public FacilityGroupingTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Cluster Name", String.class, null);
        addContainerProperty("Node Name", String.class, null);
        List<FacilityGrouping> facilityGroupings = FacilityGroupingFacade.getFacilityGroupingService().findAll();
        for (FacilityGrouping iFacilityGrouping : facilityGroupings) {
            addItem(new Object[]{iFacilityGrouping.getCluster().getClusterName(),
                iFacilityGrouping.getNode().getNodeName()
            }, iFacilityGrouping.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}

