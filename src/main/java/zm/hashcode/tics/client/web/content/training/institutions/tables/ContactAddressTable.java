/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tables;

import com.vaadin.ui.Table;
import java.util.Set;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.model.ContactAddressBean;

/**
 *
 * @author geek
 */
public class ContactAddressTable extends Table {

    private final TicsMain main;

    public ContactAddressTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Postal Address", String.class, null);
        addContainerProperty("Physical Address", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Postal COde", String.class, null);
        addContainerProperty("Email Address", String.class, null);
        addContainerProperty("City", String.class, null);

//        List<Contact> contactLists = ContactListFacade.getContactListService().findAll();
//        for (Contact iContactList : contactLists) {
//            addItem(new Object[]{iContactList.getName()
//            }, iContactList.getId());
//        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    public void populateTable(Set<ContactAddressBean> contactBeans) {

//            private String postalAddress;
//    private String physicalAddress;
//    private String contactNumber;
//    private String postalCode;
//    private String emailAddres;
////    @DBRef
////    private Location city;
//    private String cityId;
//    private String cityName;
//


        for (ContactAddressBean contactBean : contactBeans) {
//            String city = LocationFacade.getLocationService().find(contactBean.getCityId()).getName();
//            addItem(new Object[]{contactBean.getPostalAddress(),
//                contactBean.getPhysicalAddress(),
//                contactBean.getContactNumber(),
//                contactBean.getPostalCode(),
//                contactBean.getEmailAddres(),
//                city
//            }, iContactList.getId());
        }

    }
}
