/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.position.PositionTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.position.PositionType;

/**
 *
 * @author geek
 */
public class PositionTypeTable extends Table {

    private final TicsMain main;

    public PositionTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Position Name", String.class, null);

        List<PositionType> positionTypeList = PositionTypeFacade.getPositionTypeService().findAll();
        for (PositionType iPositionType : positionTypeList) {
            addItem(new Object[]{iPositionType.getName()
            }, iPositionType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
