/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.home.tabs.FacilitiesMapStatsTab;
import zm.hashcode.tics.client.web.content.home.tabs.FacilitiesStatsTab;
import zm.hashcode.tics.client.web.content.home.tabs.PeopleStatsTab;
import zm.hashcode.tics.client.web.content.users.tabs.ResetTab;

/**
 *
 * @author boniface
 */
public class HomeMenu extends Menu {

    public HomeMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout peeopleStatsTab = new VerticalLayout();
        peeopleStatsTab.setMargin(true);
        peeopleStatsTab.addComponent(new PeopleStatsTab(getMain()));


        final VerticalLayout facilitiesStatsTab = new VerticalLayout();
        facilitiesStatsTab.setMargin(true);
        facilitiesStatsTab.addComponent(new FacilitiesStatsTab(getMain()));

        final VerticalLayout coursesStatsTab = new VerticalLayout();
        coursesStatsTab.setMargin(true);
        coursesStatsTab.addComponent(new ResetTab(getMain()));

        final VerticalLayout facilitiesMapTab = new VerticalLayout();
        facilitiesMapTab.setMargin(true);
        facilitiesMapTab.addComponent(new FacilitiesMapStatsTab(getMain()));

        getTab().addTab(peeopleStatsTab, "People Stats", null);
        getTab().addTab(facilitiesStatsTab, "Facilities Stats", null);
        getTab().addTab(coursesStatsTab, "Courses Stats", null);
        getTab().addTab(facilitiesMapTab, "Facilities Map", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(peeopleStatsTab);
                break;
            case "FACILITIES":
                getTab().setSelectedTab(facilitiesStatsTab);
                break;
            case "COURSES":
                getTab().setSelectedTab(coursesStatsTab);
                break;
            case "MAP":
                getTab().setSelectedTab(facilitiesMapTab);
                break;
        }
        addComponent(getTab());

    }
}
