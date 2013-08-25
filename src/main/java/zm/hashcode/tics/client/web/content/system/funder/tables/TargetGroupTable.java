/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.TargetGroupFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.course.TargetGroup;

/**
 *
 * @author geek
 */
public class TargetGroupTable extends Table {

    private final TicsMain main;

    public TargetGroupTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);


        List<TargetGroup> targetGroup = TargetGroupFacade.getTargetGroupService().findAll();
        for (TargetGroup iTargetGroup : targetGroup) {
            addItem(new Object[]{iTargetGroup.getName()
            }, iTargetGroup.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
