/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.facility.tabs.DepartmentTab;
import zm.hashcode.tics.client.web.content.system.facility.tabs.FacilityMentorTab;
import zm.hashcode.tics.client.web.content.system.facility.tabs.FacilityTab;
import zm.hashcode.tics.client.web.content.system.facility.tabs.FacilityTypeTab;
import zm.hashcode.tics.client.web.content.system.facility.tabs.NodeAndClusterTab;
import zm.hashcode.tics.client.web.content.system.facility.tabs.RegistrationBodyTab;

/**
 *
 * @author boniface
 */
public class FacilityMenu extends Menu {

    public FacilityMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout departmenttab = new VerticalLayout();
        departmenttab.setMargin(true);
        departmenttab.addComponent(new DepartmentTab(getMain()));

        final VerticalLayout facilitypeTab = new VerticalLayout();
        facilitypeTab.setMargin(true);
        facilitypeTab.addComponent(new FacilityTypeTab(getMain()));

        final VerticalLayout facilityTab = new VerticalLayout();
        facilityTab.setMargin(true);
        facilityTab.addComponent(new FacilityTab(getMain()));

        final VerticalLayout registrationBodyTab = new VerticalLayout();
        registrationBodyTab.setMargin(true);
        registrationBodyTab.addComponent(new RegistrationBodyTab(getMain()));

        final VerticalLayout nodeAndClusterTab = new VerticalLayout();
        nodeAndClusterTab.setMargin(true);
        nodeAndClusterTab.addComponent(new NodeAndClusterTab(getMain()));

        final VerticalLayout facilityGroupingTab = new VerticalLayout();
        facilityGroupingTab.setMargin(true);
        facilityGroupingTab.addComponent(new FacilityMentorTab(getMain()));

        final VerticalLayout facilityMentorTab = new VerticalLayout();
        facilityMentorTab.setMargin(true);
        facilityMentorTab.addComponent(new FacilityMentorTab(getMain()));
        getTab().addTab(departmenttab, "Manage DEPARTMENT", null);
        getTab().addTab(facilitypeTab, "Manage FACILITY TYPE", null);
        getTab().addTab(facilityTab, "Manage FACILITY", null);
        getTab().addTab(registrationBodyTab, "Registration BODY", null);
        getTab().addTab(nodeAndClusterTab, "Manage NODE and CLUSTER", null);
        getTab().addTab(facilityGroupingTab, "Facility GROUPING", null);
        getTab().addTab(facilityMentorTab, "Attach FACILITY MENTOR", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(departmenttab);
                break;
            case "FACILITYTYPE":
                getTab().setSelectedTab(facilitypeTab);
                break;
            case "FACILITY":
                getTab().setSelectedTab(facilityTab);
                break;

            case "REGBODY":
                getTab().setSelectedTab(registrationBodyTab);
                break;

            case "GROUPING":
                getTab().setSelectedTab(registrationBodyTab);
                break;

            case "NODE":
                getTab().setSelectedTab(nodeAndClusterTab);
                break;
            case "MENTOR":
                getTab().setSelectedTab(facilityMentorTab);
                break;
        }
        addComponent(getTab());

    }
}
