/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.tabs.CourseTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.CourseTypeTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.CriteriaTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.ScheduledCourseTab;
import zm.hashcode.tics.client.web.content.training.institutions.tabs.TrainingInstructorsTab;
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

        final VerticalLayout trainingInstructorsTab = new VerticalLayout();
        trainingInstructorsTab.setMargin(true);
        trainingInstructorsTab.addComponent(new TrainingInstructorsTab(getMain()));

        getTab().addTab(trainingInstructorsTab, "Add INSTRUCTORS", null);
        getTab().addTab(courseTypeTab, "Add CONTACTS", null);


        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(trainingInstructorsTab);
                break;
            case "CONTACTS":
                getTab().setSelectedTab(courseTypeTab);
                break;

        }
        addComponent(getTab());

    }
}
