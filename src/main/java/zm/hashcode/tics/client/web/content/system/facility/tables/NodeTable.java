/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.NodeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Node;

/**
 *
 * @author geek
 */
public class NodeTable extends Table {

    private final TicsMain main;

    public NodeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Node Name", String.class, null);
        List<Node> nodes = NodeFacade.getNodeService().findAll();
        for (Node iNode : nodes) {
            addItem(new Object[]{iNode.getNodeName()
            }, iNode.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
