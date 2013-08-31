/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.course.tabs.CategoryTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.CourseTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.CourseTypeTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.CriteriaTab;
import zm.hashcode.tics.client.web.content.training.course.tabs.ScheduledCourseTab;

/**
 *
 * @author boniface
 */
public class CourseMenu extends Menu {

    public CourseMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

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

        final VerticalLayout courseCategoryTab = new VerticalLayout();
        courseCategoryTab.setMargin(true);
        courseCategoryTab.addComponent(new CategoryTab(getMain()));

        getTab().addTab(courseTypeTab, "Add COURSE TYPE", null);
        getTab().addTab(courseCategoryTab, "Add COURSE CATEGORY", null);
        getTab().addTab(criteriaTab, "Add COURSE CRITERIA", null);
        getTab().addTab(courseTab, "Add COURSES", null);
        getTab().addTab(scheduledCourseTab, "Schedeule COURSES", null);

        switch (selectedTab) {
            case "COURSETYPE":
                getTab().setSelectedTab(courseTypeTab);
                break;
            case "COURSECATEGORY":
                getTab().setSelectedTab(courseCategoryTab);
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
        }
        addComponent(getTab());

    }
}
