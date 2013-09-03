/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.tabs.CourseTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.ScheduledCourseTab;

/**
 *
 * @author boniface
 */
public class CourseMenu extends Menu {

    public CourseMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout courseTab = new VerticalLayout();
        courseTab.setMargin(true);
        courseTab.addComponent(new CourseTab(getMain()));

        final VerticalLayout scheduledCourseTab = new VerticalLayout();
        scheduledCourseTab.setMargin(true);
        scheduledCourseTab.addComponent(new ScheduledCourseTab(getMain()));

        final VerticalLayout evaluationTab = new VerticalLayout();
        evaluationTab.setMargin(true);
        evaluationTab.addComponent(new ScheduledCourseTab(getMain()));

        getTab().addTab(courseTab, "Add COURSES", null);
        getTab().addTab(scheduledCourseTab, "Schedeule COURSES", null);
        getTab().addTab(evaluationTab, "Evaluate Course PARTICIPANTS", null);

        switch (selectedTab) {

            case "COURSES":
                getTab().setSelectedTab(courseTab);
                break;
            case "SCHEDULECOURSES":
                getTab().setSelectedTab(scheduledCourseTab);
                break;
            case "EVALUATE":
                getTab().setSelectedTab(scheduledCourseTab);
                break;
        }
        addComponent(getTab());

    }
}
