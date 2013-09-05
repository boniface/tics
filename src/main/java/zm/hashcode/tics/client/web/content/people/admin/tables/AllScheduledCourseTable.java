/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tables;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author geek
 */
public class AllScheduledCourseTable extends Table {

    private final TicsMain main;

    public AllScheduledCourseTable(TicsMain main) {
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
        for (ScheduledCourse scheduledCourse : scheduledCourses) {
            Button showDetails = new Button("Details");
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
