/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.ContactListFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.location.ContactList;

/**
 *
 * @author geek
 */
public class ContactListTable extends Table {

    private final TicsMain main;

    public ContactListTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        List<ContactList> contactLists = ContactListFacade.getContactListService().findAll();
        for (ContactList iContactList : contactLists) {
            addItem(new Object[]{iContactList.getName()
            }, iContactList.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
