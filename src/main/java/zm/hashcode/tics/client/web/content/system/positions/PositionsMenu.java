/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.positions.tabs.JobClassificationTab;
import zm.hashcode.tics.client.web.content.system.positions.tabs.JobTab;
import zm.hashcode.tics.client.web.content.system.positions.tabs.PositionTab;
import zm.hashcode.tics.client.web.content.system.positions.tabs.PositionTypeTab;
import zm.hashcode.tics.client.web.content.system.positions.tabs.ReasonsForDepartureTab;

/**
 *
 * @author boniface
 */
public class PositionsMenu extends Menu {

    public PositionsMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout reasonsTab = new VerticalLayout();
        reasonsTab.setMargin(true);
        reasonsTab.addComponent(new ReasonsForDepartureTab(getMain()));

        final VerticalLayout jobClassificatrionTab = new VerticalLayout();
        jobClassificatrionTab.setMargin(true);
        jobClassificatrionTab.addComponent(new JobClassificationTab(getMain()));

        final VerticalLayout jobTab = new VerticalLayout();
        jobTab.setMargin(true);
        jobTab.addComponent(new JobTab(getMain()));

        final VerticalLayout positionTab = new VerticalLayout();
        positionTab.setMargin(true);
        positionTab.addComponent(new PositionTab(getMain()));

        final VerticalLayout positionType = new VerticalLayout();
        positionType.setMargin(true);
        positionType.addComponent(new PositionTypeTab(getMain()));

        getTab().addTab(jobClassificatrionTab, "Job CLASSIFICATION", null);
        getTab().addTab(jobTab, "JOB", null);
        getTab().addTab(positionType, "Position TYPE", null);
        getTab().addTab(positionTab, "POSITIONS", null);
        getTab().addTab(reasonsTab, "Reasons for DEPATURE", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(jobClassificatrionTab);
                break;
            case "JOB":
                getTab().setSelectedTab(jobTab);
                break;
            case "POSITIONTYPE":
                getTab().setSelectedTab(positionType);
                break;
            case "POSITION":
                getTab().setSelectedTab(positionTab);
                break;
            case "DEPARTURE":
                getTab().setSelectedTab(reasonsTab);
                break;
        }
        addComponent(getTab());

    }
}
