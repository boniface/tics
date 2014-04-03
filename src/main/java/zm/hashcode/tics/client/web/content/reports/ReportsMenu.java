/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.reports.tabs.GenerateReportTab;
import zm.hashcode.tics.client.web.content.reports.tabs.SetReportTab;

/**
 *
 * @author boniface
 */
public class ReportsMenu extends Menu {

    public ReportsMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout generateReportTab = new VerticalLayout();
        generateReportTab.setMargin(true);
        generateReportTab.addComponent(new GenerateReportTab(getMain()));

        final VerticalLayout setReportTab = new VerticalLayout();
        setReportTab.setMargin(true);
        setReportTab.addComponent(new SetReportTab(getMain()));

        getTab().addTab(generateReportTab, "Generate Reports", null);
        getTab().addTab(setReportTab, "Set Up Reports", null);
        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(generateReportTab);
                break;

            case "SETUP":
                getTab().setSelectedTab(setReportTab);
                break;
        }
        addComponent(getTab());
    }
}
