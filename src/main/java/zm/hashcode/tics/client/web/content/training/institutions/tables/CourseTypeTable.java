/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CourseTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.course.CourseType;

/**
 *
 * @author geek
 */
public class CourseTypeTable extends Table {

    private final TicsMain main;

    public CourseTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);

        List<CourseType> courseTypes = CourseTypeFacade.getCourseTypeService().findAll();
        for (CourseType iCourseType : courseTypes) {
            addItem(new Object[]{iCourseType.getName()
            }, iCourseType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
