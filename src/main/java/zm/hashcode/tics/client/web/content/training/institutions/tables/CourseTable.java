/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.course.Course;

/**
 *
 * @author geek
 */
public class CourseTable extends Table {

    private final TicsMain main;

    public CourseTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        addContainerProperty("Course Objective", String.class, null);
        addContainerProperty("Course Topic", String.class, null);
        addContainerProperty("Course Status", String.class, null);

        List<Course> courses = CourseFacade.getCourseService().findAll();
        for (Course iCourse : courses) {
            addItem(new Object[]{iCourse.getName(),
                iCourse.getCourseObjective(),
                iCourse.getCourseTopic(),
                iCourse.getCourseStatus()
            }, iCourse.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
