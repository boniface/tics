/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.AddressTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.location.AddressType;

/**
 *
 * @author geek
 */
public class AddressTypeTable extends Table {

    private final TicsMain main;

    public AddressTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Address Type", String.class, null);
        List<AddressType> addressTypes = AddressTypeFacade.getAddressTypeService().findAll();
        for (AddressType iAddressType : addressTypes) {
            addItem(new Object[]{iAddressType.getAddressTypeName()
            }, iAddressType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
