/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tables;

import com.google.common.collect.Collections2;
import com.vaadin.ui.Table;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.services.training.institutions.schedule.predicates.InstitutionScheduledCoursePredicate;

/**
 *
 * @author geek
 */
public class ScheduledCourseTable extends Table {

    private final TicsMain main;

    public ScheduledCourseTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Venue", String.class, null);
        addContainerProperty("Course Capacity", Integer.class, null);
        addContainerProperty("Credit Hours", Integer.class, null);
        addContainerProperty("Start Date", Date.class, null);
        addContainerProperty("End Date", Date.class, null);

        List<ScheduledCourse> scheduledCourses = ScheduledCourseFacade.getScheduledCourseService().findAll();
        Collection<ScheduledCourse> institutionScheduledCourses = Collections2.filter(scheduledCourses, new InstitutionScheduledCoursePredicate());
        for (ScheduledCourse uScheduledCourse : institutionScheduledCourses) {
            addItem(new Object[]{uScheduledCourse.getVenue(),
                uScheduledCourse.getCourseCapacity(),
                uScheduledCourse.getCreditHours(),
                uScheduledCourse.getStartDate(),
                uScheduledCourse.getEndDate()
            }, uScheduledCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
