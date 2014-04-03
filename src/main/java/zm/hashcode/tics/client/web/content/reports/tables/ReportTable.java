/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.tables;

import com.vaadin.ui.Table;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.domain.reports.Report;

/**
 *
 * @author boniface
 */
public class ReportTable extends Table {

    public ReportTable(List<Report> report) {
        setSizeFull();

        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Last Name", String.class, null);
        addContainerProperty("Course ", String.class, null);
        addContainerProperty("Topic ", String.class, null);
        addContainerProperty("Facility ", String.class, null);
        addContainerProperty("Training Venue ", String.class, null);

        addContainerProperty("City", String.class, null);
        addContainerProperty("Sub District", String.class, null);
        addContainerProperty("District ", String.class, null);


        addContainerProperty("Course Start Date ", Date.class, null);
        addContainerProperty("Course End Date ", Date.class, null);

        for (Report p : report) {
            addItem(new Object[]{
                p.getFirstName(),
                p.getLastName(),
                p.getCourseName(),
                p.getCourseTopic(),
                p.getFacility(),
                p.getVenue(),
                p.getCity(),
                p.getSubstrict(),
                p.getDistrict(),
                p.getStartDate(),
               p.getEndDate()}, p.getId());
        }

        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
