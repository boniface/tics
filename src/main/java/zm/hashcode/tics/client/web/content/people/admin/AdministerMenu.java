/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.ManageMentoringTab;
import zm.hashcode.tics.client.web.content.people.admin.tabs.ManagePeopleTab;
import zm.hashcode.tics.client.web.content.people.admin.tabs.ManageTrainingTab;

/**
 *
 * @author boniface
 */
public class AdministerMenu extends Menu {

    public AdministerMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout managePeopleTab = new VerticalLayout();
        managePeopleTab.setMargin(true);
        managePeopleTab.addComponent(new ManagePeopleTab(getMain()));


        final VerticalLayout manageTrainingTab = new VerticalLayout();
        manageTrainingTab.setMargin(true);
        manageTrainingTab.addComponent(new ManageTrainingTab(getMain()));

        final VerticalLayout manageMentoringTab = new VerticalLayout();
        manageMentoringTab.setMargin(true);
        manageMentoringTab.addComponent(new ManageMentoringTab(getMain()));

        getTab().addTab(managePeopleTab, "Manage PEOPLE", null);
        getTab().addTab(manageTrainingTab, "Manage TRAINING", null);
        getTab().addTab(manageMentoringTab, "Manage MENTORING", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(managePeopleTab);
                break;
            case "TRAINING":
                getTab().setSelectedTab(manageTrainingTab);
                break;
            case "MENTORING":
                getTab().setSelectedTab(manageTrainingTab);
                break;
        }
        addComponent(getTab());

    }
}
