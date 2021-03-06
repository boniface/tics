/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tables;

import com.google.common.collect.Collections2;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import java.text.SimpleDateFormat;
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
        addContainerProperty("Course", String.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Venue", String.class, null);
        addContainerProperty("Course Capacity", Integer.class, null);
        addContainerProperty("Credit Hours", Integer.class, null);
        addContainerProperty("Enrolled ", Integer.class, null);
        addContainerProperty("Start Date", String.class, null);
        addContainerProperty("End Date", String.class, null);
        addContainerProperty("Details", Button.class, null);




        List<ScheduledCourse> scheduledCourses = ScheduledCourseFacade.getScheduledCourseService().findAll();
        Collection<ScheduledCourse> institutionScheduledCourses = Collections2.filter(scheduledCourses, new InstitutionScheduledCoursePredicate());
        for (ScheduledCourse scheduledCourse : institutionScheduledCourses) {
            Button showDetails = new Button("Edit");
            showDetails.setData(scheduledCourse.getId());
            showDetails.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    String itemId = (String) event.getButton().getData();
                    ScheduledCourse scheduledCourse = ScheduledCourseFacade.getScheduledCourseService().find(itemId);


                }
            });

            showDetails.setStyleName(Reindeer.BUTTON_LINK);

            addItem(new Object[]{
                scheduledCourse.getCourse().getName(),
                getStatus(scheduledCourse),
                scheduledCourse.getVenue(),
                scheduledCourse.getCourseCapacity(),
                scheduledCourse.getCreditHours(),
                scheduledCourse.getParticipants().size(),
                getDate(scheduledCourse.getStartDate()),
                getDate(scheduledCourse.getEndDate()),
                showDetails
            }, scheduledCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getDate(Date startDate) {
        if (startDate != null) {
            return new SimpleDateFormat("dd-MMMM-yyyy").format(startDate);
        }
        return null;
    }

    private String getStatus(ScheduledCourse course) {
        if (course.getParticipants().size() < course.getCourseCapacity()) {
            return "OPEN";
        }
        return "FULL";
    }
}
