/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.competencies.tabs.CompetencyTab;
import zm.hashcode.tics.client.web.content.system.competencies.tabs.CompetencyTypeTab;
import zm.hashcode.tics.client.web.content.system.competencies.tabs.EvaluationTab;

/**
 *
 * @author boniface
 */
public class CompetenciesMenu extends Menu {

    public CompetenciesMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout competencyTypeTab = new VerticalLayout();
        competencyTypeTab.setMargin(true);
        competencyTypeTab.addComponent(new CompetencyTypeTab(getMain()));


        final VerticalLayout competencyTab = new VerticalLayout();
        competencyTab.setMargin(true);
        competencyTab.addComponent(new CompetencyTab(getMain()));

        final VerticalLayout evaluationTab = new VerticalLayout();
        evaluationTab.setMargin(true);
        evaluationTab.addComponent(new EvaluationTab(getMain()));

        getTab().addTab(competencyTypeTab, "Add Compentency TYPE", null);
        getTab().addTab(competencyTab, "Add COMPETENCY", null);
        getTab().addTab(evaluationTab, "Add EVALUATION", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(competencyTypeTab);
                break;
            case "COMPETENCY":
                getTab().setSelectedTab(competencyTab);
                break;
            case "EVALUATION":
                getTab().setSelectedTab(evaluationTab);
                break;
        }
        addComponent(getTab());

    }
}
