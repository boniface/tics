/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.training;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.training.tabs.CategoryTab;
import zm.hashcode.tics.client.web.content.system.training.tabs.CourseTypeTab;
import zm.hashcode.tics.client.web.content.system.training.tabs.CriteriaTab;
import zm.hashcode.tics.client.web.content.system.training.tabs.TrainingInstitutionTab;

/**
 *
 * @author boniface
 */
public class TrainingSetupMenu extends Menu {

    public TrainingSetupMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout trainingTab = new VerticalLayout();
        trainingTab.setMargin(true);
        trainingTab.addComponent(new TrainingInstitutionTab(getMain()));

        final VerticalLayout courseTypeTab = new VerticalLayout();
        courseTypeTab.setMargin(true);
        courseTypeTab.addComponent(new CourseTypeTab(getMain()));

        final VerticalLayout criteriaTab = new VerticalLayout();
        criteriaTab.setMargin(true);
        criteriaTab.addComponent(new CriteriaTab(getMain()));

        final VerticalLayout courseCategoryTab = new VerticalLayout();
        courseCategoryTab.setMargin(true);
        courseCategoryTab.addComponent(new CategoryTab(getMain()));



        getTab().addTab(trainingTab, "Training INSTITUTION", null);
        getTab().addTab(courseTypeTab, "Add COURSE TYPE", null);
        getTab().addTab(courseCategoryTab, "Add COURSE CATEGORY", null);
        getTab().addTab(criteriaTab, "Add COURSE CRITERIA", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(trainingTab);
                break;
            case "COURSETYPE":
                getTab().setSelectedTab(courseTypeTab);
                break;
            case "COURSECATEGORY":
                getTab().setSelectedTab(courseCategoryTab);
                break;
            case "COURSECRITERIA":
                getTab().setSelectedTab(criteriaTab);
                break;

        }
        addComponent(getTab());

    }
}
