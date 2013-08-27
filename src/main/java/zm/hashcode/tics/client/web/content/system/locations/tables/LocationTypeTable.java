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
        addContainerProperty("Location Type Name", String.class, null);
        addContainerProperty("Location Type Code", String.class, null);

        List<LocationType> locationsLocationTypes = LocationTypeFacade.getLocationTypeService().findAll();
        for (LocationType locationType : locationsLocationTypes) {
            addItem(new Object[]{
                locationType.getName(),
                locationType.getCode()
            }, locationType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
