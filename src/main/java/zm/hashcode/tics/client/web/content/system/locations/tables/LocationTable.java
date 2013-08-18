/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author geek
 */
public class LocationTable extends Table {

    private final TicsMain main;

    public LocationTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("UNDER CONSTRUCTION", String.class, null);

//        List<AddressType> addressTypes = AddressTypeFacade.getAddressTypeService().findAll();
//        for (AddressType iAddressType : addressTypes) {
//            addItem(new Object[]{iAddressType.getAddressTypeName()
//            }, iAddressType.getId());
//        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
