/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author geek
 */
public class LocationAddressTable extends Table {

    private final TicsMain main;

    public LocationAddressTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Postal Address", String.class, null);
        addContainerProperty("PhysicalAddress", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Postal Code", String.class, null);
        addContainerProperty("Email Address", String.class, null);

//        List<LocationAddress> locationAddress = LocationAddressFacade.getLocationAddressService().findAll();
//        for (LocationAddress iLocationAddress : locationAddress) {
//            addItem(new Object[]{iLocationAddress.getPostalAddress(),
//                iLocationAddress.getPhysicalAddress(),
//                iLocationAddress.getContactNumber(),
//                iLocationAddress.getPostalCode(),
//                iLocationAddress.getEmailAddress()
//            }, iLocationAddress.getId());
//        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
