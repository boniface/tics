/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.funder.tabs.FunderTab;
import zm.hashcode.tics.client.web.content.system.funder.tabs.StatusTab;
import zm.hashcode.tics.client.web.content.system.funder.tabs.TargetGroupTab;
import zm.hashcode.tics.client.web.content.users.tabs.RoleTab;
import zm.hashcode.tics.client.web.content.users.tabs.UserTab;

/**
 *
 * @author boniface
 */
public class FunderMenu extends Menu {

    public FunderMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout funderTab = new VerticalLayout();
        funderTab.setMargin(true);
        funderTab.addComponent(new FunderTab(getMain()));


        final VerticalLayout targetGroupTab = new VerticalLayout();
        targetGroupTab.setMargin(true);
        targetGroupTab.addComponent(new TargetGroupTab(getMain()));

        final VerticalLayout statusTab = new VerticalLayout();
        statusTab.setMargin(true);
        statusTab.addComponent(new StatusTab(getMain()));

        getTab().addTab(funderTab, "Add FUNDER", null);
        getTab().addTab(targetGroupTab, "Add TARGET GROUP", null);
        getTab().addTab(statusTab, "Add STATUS", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(funderTab);
                break;
            case "TARGETGROUP":
                getTab().setSelectedTab(targetGroupTab);
                break;
            case "STATUS":
                getTab().setSelectedTab(statusTab);
                break;
        }
        addComponent(getTab());

    }
}
