/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.tabs;

import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.report.ReportFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.reports.tables.ReportTable;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.reports.Report;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
public class SetReportTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HorizontalLayout buttonLayout = new HorizontalLayout();
    private final TicsMain main;
    private final List<Location> locations = LocationFacade.getLocationService().findAll();
    private final List<Report> reports = ReportFacade.getReportService().findAll();

    private final Button setReportButton = new Button("Set Up RAW Report");
    private final Button deleteReportReportButton = new Button("Delete RAW Generated Report");

    private final HorizontalLayout tablelayout = new HorizontalLayout();

    public SetReportTab(TicsMain main) {

        tablelayout.setSizeFull();
        this.main = main;
        setSizeFull();
        buttonLayout.setSizeFull();
        setReportButton.setStyleName("default");
        setReportButton.setWidth("300px");
        deleteReportReportButton.setStyleName("default");
        deleteReportReportButton.setWidth("300px");
        buttonLayout.addComponent(setReportButton);
        buttonLayout.addComponent(deleteReportReportButton);
        addComponent(buttonLayout);

        addComponent(new Label("<HR/>", ContentMode.HTML));

        addListeners();

        addComponent(new Label("<HR/>", ContentMode.HTML));

        List<Report> report = new ArrayList<>();
        ReportTable table = new ReportTable(report);
        tablelayout.addComponent(table);
        addComponent(tablelayout);

    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == deleteReportReportButton) {
            deleteOldreport();
            tablelayout.removeAllComponents();
            List<Report> report = new ArrayList<>();
            ReportTable table = new ReportTable(report);
            tablelayout.addComponent(table);

        } else {
            
            
            if (ReportFacade.getReportService().findAll().size() < 1) {
                generateRawReport();
                tablelayout.removeAllComponents();
                List<Report> r = ReportFacade.getReportService().findAll();
                ReportTable table = new ReportTable(r);
                tablelayout.addComponent(table);
            } else {
                Notification.show("There is already a RAW Report Setup. Delete The Current RAW Report First!", Notification.Type.ERROR_MESSAGE);
                tablelayout.removeAllComponents();
                List<Report> r = ReportFacade.getReportService().findAll();
                ReportTable table = new ReportTable(r);
                tablelayout.addComponent(table);
            }
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();

    }

    private void addListeners() {
        //Register Button Listeners

        setReportButton.addClickListener((Button.ClickListener) this);
        deleteReportReportButton.addClickListener((Button.ClickListener) this);
        //Register Table Listerners

    }

    private void generateRawReport() {
        List<ScheduledCourse> courses = ScheduledCourseFacade.getScheduledCourseService().findAll();

        courses.stream().parallel().filter((c) -> (c.getParticipants().size() > 0)).forEach((c) -> {
            Set<Person> people = c.getParticipants();
            people.remove(null);
            people.stream().parallel().filter((person) -> (person.getFacility() != null)).map((person) -> new Report.Builder(c.getCourse().getName())
                    .facility(person.getFacility().getFacilityName())
                    .courseTopic(c.getCourse().getCourseTopic())
                    .city(getCity(person.getFacility().getCity()))
                    .substrict(getSubDistrict(person.getFacility().getCity()))
                    .district(getDistrict(person.getFacility().getCity()))
                    .endDate(c.getEndDate())
                    .startDate(c.getStartDate())
                    .firstName(person.getFirstname())
                    .lastName(person.getSurname())
                    .personId(person.getId())
                    .venue(c.getVenue()).build()).forEach((r) -> {
                        ReportFacade.getReportService().persist(r);
                    });
        });
    }

    private String getCity(Location city) {
        if (city != null) {
            return city.getName();
        }
        return "NO CITY NAME";
    }

    private String getSubDistrict(Location city) {
        if (city != null) {
            return getSubD(city.getParent());
        }
        return "NO CITY";

    }

    private String getSubD(Location parent) {
        if (parent != null) {
            return parent.getName();
        }
        return "NO SUB DISTRICT";
    }

    private String getDistrict(Location city) {
        if (city != null) {
            return getDistrictSub(city.getParent());
        }
        return "NO CITY NAME";

    }

    private String getDistrictSub(Location parent) {
        if (parent != null) {
            return getDist(parent.getParent());
        }
        return "NO SUB DISTRICT";
    }

    private String getDist(Location parent) {
        if (parent != null) {
            return parent.getName();
        }
        return "DISTRICT";
    }

    private void deleteOldreport() {
        List<Report> reps = ReportFacade.getReportService().findAll();

        reps.stream().parallel().forEach((report) -> {
            ReportFacade.getReportService().remove(report);
        });
    }

}
