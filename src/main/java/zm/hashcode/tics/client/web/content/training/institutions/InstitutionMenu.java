/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.tabs.CourseTab;
import zm.hashcode.tics.client.web.content.training.institutions.tabs.CourseTypeTab;
import zm.hashcode.tics.client.web.content.training.institutions.tabs.CriteriaTab;
import zm.hashcode.tics.client.web.content.training.institutions.tabs.ScheduledCourseTab;
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

        final VerticalLayout courseTypeTab = new VerticalLayout();
        courseTypeTab.setMargin(true);
        courseTypeTab.addComponent(new CourseTypeTab(getMain()));

        final VerticalLayout criteriaTab = new VerticalLayout();
        criteriaTab.setMargin(true);
        criteriaTab.addComponent(new CriteriaTab(getMain()));

        final VerticalLayout courseTab = new VerticalLayout();
        courseTab.setMargin(true);
        courseTab.addComponent(new CourseTab(getMain()));

        final VerticalLayout scheduledCourseTab = new VerticalLayout();
        scheduledCourseTab.setMargin(true);
        scheduledCourseTab.addComponent(new ScheduledCourseTab(getMain()));


        getTab().addTab(trainingInstructorsTab, "Add INSTRUCTORS", null);
        getTab().addTab(courseTypeTab, "Add COURSE TYPE", null);
        getTab().addTab(criteriaTab, "Add COURSE CRITERIA", null);
        getTab().addTab(courseTab, "Add COURSES", null);
        getTab().addTab(scheduledCourseTab, "Schedeule COURSES", null);
//        getTab().addTab(rese0tTab, "Grade PARTICIPANTS", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(trainingInstructorsTab);
                break;
            case "COURSETYPE":
                getTab().setSelectedTab(courseTypeTab);
                break;
            case "COURSECRITERIA":
                getTab().setSelectedTab(criteriaTab);
                break;
            case "COURSES":
                getTab().setSelectedTab(courseTab);
                break;
            case "SCHEDULECOURSES":
                getTab().setSelectedTab(scheduledCourseTab);
                break;
//            case "GRADEPARTICIPANTS":
//                getTab().setSelectedTab(ypeTab);
//                break;
        }
        addComponent(getTab());

    }
}
