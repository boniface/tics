/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.mentoring.tabs.MentoringObjectiveTab;
import zm.hashcode.tics.client.web.content.system.mentoring.tabs.MentoringStrentheningTab;
import zm.hashcode.tics.client.web.content.system.mentoring.tabs.MentoringSubjectAreaTab;
import zm.hashcode.tics.client.web.content.system.mentoring.tabs.MentoringThemeTab;
import zm.hashcode.tics.client.web.content.system.mentoring.tabs.MentoringToolsMethodsTab;

/**
 *
 * @author boniface
 */
public class MentoringSetupMenu extends Menu {

    public MentoringSetupMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout mentoringSubjectAreaTab = new VerticalLayout();
        mentoringSubjectAreaTab.setMargin(true);
        mentoringSubjectAreaTab.addComponent(new MentoringSubjectAreaTab(getMain()));

        final VerticalLayout mentoringStrentheningTab = new VerticalLayout();
        mentoringStrentheningTab.setMargin(true);
        mentoringStrentheningTab.addComponent(new MentoringStrentheningTab(getMain()));

        final VerticalLayout mentoringObjectiveTab = new VerticalLayout();
        mentoringObjectiveTab.setMargin(true);
        mentoringObjectiveTab.addComponent(new MentoringObjectiveTab(getMain()));

        final VerticalLayout mentoringThemeTab = new VerticalLayout();
        mentoringThemeTab.setMargin(true);
        mentoringThemeTab.addComponent(new MentoringThemeTab(getMain()));

        final VerticalLayout mentoringToolsTab = new VerticalLayout();
        mentoringToolsTab.setMargin(true);
        mentoringToolsTab.addComponent(new MentoringToolsMethodsTab(getMain()));

        getTab().addTab(mentoringSubjectAreaTab, "Mentoring Subject AREA", null);
        getTab().addTab(mentoringThemeTab, "Mentoring THEME", null);
        getTab().addTab(mentoringObjectiveTab, "Mentoring OBJECTIVE", null);
        getTab().addTab(mentoringStrentheningTab, "Areas of STRENTHENING", null);
        getTab().addTab(mentoringToolsTab, "Mentoring TOOLS ans METHODS", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(mentoringSubjectAreaTab);
                break;

            case "THEME":
                getTab().setSelectedTab(mentoringThemeTab);
                break;

            case "OBJECTIVE":
                getTab().setSelectedTab(mentoringObjectiveTab);
                break;

            case "STRENTHENING":
                getTab().setSelectedTab(mentoringStrentheningTab);
                break;

            case "TOOLS":
                getTab().setSelectedTab(mentoringToolsTab);
                break;

        }
        addComponent(getTab());

    }
}
