/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationTable extends Table {

    private final TicsMain main;

    public LocationTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Location Name", String.class, null);
        addContainerProperty("Location Type", String.class, null);
        addContainerProperty("Location Code", String.class, null);


        List<Location> locations = LocationFacade.getLocationService().findAll();
        for (Location location : locations) {
            addItem(new Object[]{
                location.getName(),
                getLocationType(location.getLocationType()),
                location.getCode()
            }, location.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getLocationType(LocationType locationType) {
        if (locationType != null) {
            return locationType.getName();
        }
        return null;
    }
}
