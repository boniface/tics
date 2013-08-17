/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.ClusterFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Cluster;

/**
 *
 * @author geek
 */
public class ClusterTable extends Table {

    private final TicsMain main;

    public ClusterTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Cluster Name", String.class, null);
        List<Cluster> clusters = ClusterFacade.getClusterService().findAll();
        for (Cluster iCluster : clusters) {
            addItem(new Object[]{iCluster.getClusterName()
            }, iCluster.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
