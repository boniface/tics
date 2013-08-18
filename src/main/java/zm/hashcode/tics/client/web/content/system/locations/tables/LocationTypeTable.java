/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationTypeTable extends Table {

    private final TicsMain main;

    public LocationTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        addContainerProperty("Code", String.class, null);
        List<LocationType> locations = LocationTypeFacade.getLocationTypeService().findAll();
        for (LocationType iLocation : locations) {
            addItem(new Object[]{iLocation.getName(),
                iLocation.getCode()
            }, iLocation.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
