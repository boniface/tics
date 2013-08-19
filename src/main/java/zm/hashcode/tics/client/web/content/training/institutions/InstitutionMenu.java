/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions;

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
public class InstitutionMenu extends Menu {

    public InstitutionMenu(TicsMain app, String selectedTab) {
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

        getTab().addTab(userTab, "Add System USERS", null);
        getTab().addTab(roleTab, "Add System ROLES", null);
        getTab().addTab(resetTab, "Reset CREDENTIALS", null);

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
