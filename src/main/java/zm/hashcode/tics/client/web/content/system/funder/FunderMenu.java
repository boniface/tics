/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.tabs.ResetTab;
import zm.hashcode.tics.client.web.content.users.tabs.RoleTab;
import zm.hashcode.tics.client.web.content.users.tabs.UserTab;

/**
 *
 * @author boniface
 */
public class FunderMenu extends Menu {

    public FunderMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout userTab = new VerticalLayout();
        userTab.setMargin(true);
        userTab.addComponent(new UserTab(getMain()));


        final VerticalLayout roleTab = new VerticalLayout();
        roleTab.setMargin(true);
        roleTab.addComponent(new RoleTab(getMain()));

        final VerticalLayout resetTab = new VerticalLayout();
        resetTab.setMargin(true);
        resetTab.addComponent(new ResetTab(getMain()));

        getTab().addTab(userTab, "Add FUNDER", null);
        getTab().addTab(roleTab, "Add TARGET GROUP", null);
        getTab().addTab(resetTab, "Add STATUS", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(userTab);
                break;
            case "ROLES":
                getTab().setSelectedTab(roleTab);
                break;
            case "RESETS":
                getTab().setSelectedTab(roleTab);
                break;
        }
        addComponent(getTab());

    }
}
