/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.locations.tabs.AddressTypeTab;
import zm.hashcode.tics.client.web.content.system.locations.tabs.ContactListTab;
import zm.hashcode.tics.client.web.content.system.locations.tabs.LocationAddressTab;
import zm.hashcode.tics.client.web.content.system.locations.tabs.LocationTab;
import zm.hashcode.tics.client.web.content.system.locations.tabs.LocationTypeTab;

/**
 *
 * @author boniface
 */
public class LocationsMenu extends Menu {

    public LocationsMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout addressTypeTab = new VerticalLayout();
        addressTypeTab.setMargin(true);
        addressTypeTab.addComponent(new AddressTypeTab(getMain()));

        final VerticalLayout contactListTab = new VerticalLayout();
        contactListTab.setMargin(true);
        contactListTab.addComponent(new ContactListTab(getMain()));

        final VerticalLayout locationTab = new VerticalLayout();
        locationTab.setMargin(true);
        locationTab.addComponent(new LocationTab(getMain()));

        final VerticalLayout locationTypeTab = new VerticalLayout();
        locationTypeTab.setMargin(true);
        locationTypeTab.addComponent(new LocationTypeTab(getMain()));

        getTab().addTab(addressTypeTab, "Address Type", null);
        getTab().addTab(contactListTab, "Contact List", null);
        getTab().addTab(locationTypeTab, "Location Type", null);
        getTab().addTab(locationTab, "Location", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(addressTypeTab);
                break;
            case "CONTACTLIST":
                getTab().setSelectedTab(contactListTab);
                break;
            case "LOCATION":
                getTab().setSelectedTab(locationTypeTab);
                break;
            case "LOCATIONTYPE":
                getTab().setSelectedTab(locationTypeTab);
                break;

        }
        addComponent(getTab());

    }
}
