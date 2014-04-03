/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.tabs;

import com.google.common.collect.Collections2;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationTypeFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.reports.ReportsMenu;
import zm.hashcode.tics.client.web.content.reports.tables.ReportTable;
import zm.hashcode.tics.client.web.content.reports.util.PeopleData;
import zm.hashcode.tics.client.web.content.reports.util.ReportQuery;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.reports.Report;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;
import zm.hashcode.tics.domain.ui.position.Position;
import zm.hashcode.tics.services.ui.location.predicates.LocationTypePredicate;

/**
 *
 * @author boniface
 */
public class GenerateReportTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final HorizontalLayout dateRangeLayout = new HorizontalLayout();
    private final HorizontalLayout professionLayout = new HorizontalLayout();
    private final HorizontalLayout locationLayout = new HorizontalLayout();
    private final TicsMain main;
    private final List<LocationType> locationTypes = LocationTypeFacade.getLocationTypeService().findAll();
    private final List<Location> locations = LocationFacade.getLocationService().findAll();
    private final List<Course> courses = CourseFacade.getCourseService().findAll();
    private final List<Facility> facilities = FacilityFacade.getFacilityService().findAll();
    private final List<Position> professions = PositionFacade.getPositionService().findAll();
    private final List<Location> updatedLocation = new ArrayList<>();
    private final ComboBox comboLocationTypes = new ComboBox("Location Type");
    private final ComboBox comboLocation = new ComboBox("Location !!!");
    private final ComboBox comboFacilities = new ComboBox("Facilities");
    private final ComboBox comboCourse = new ComboBox("Course");
    private final ComboBox comboProfession = new ComboBox("Profession");
    private final Button generateReportButton = new Button("Gemerate report");
    private final DateField startDate = new DateField("Start Date: ");
    private final DateField endDate = new DateField("End Date");
    private final HorizontalLayout tablelayout = new HorizontalLayout();

    public GenerateReportTab(TicsMain main) {
        generateReportButton.setSizeFull();
        tablelayout.setSizeFull();
        this.main = main;
        setSizeFull();
        dateRangeLayout.setSizeFull();
        startDate.setWidth(250, Unit.PIXELS);
        endDate.setWidth(250, Unit.PIXELS);
        dateRangeLayout.addComponent(startDate);
        dateRangeLayout.addComponent(endDate);
        addComponent(dateRangeLayout);
        addComponent(new Label("<HR/>", ContentMode.HTML));
        addListeners();
        for (Facility facility : facilities) {
            comboFacilities.addItem(facility.getId());
            comboFacilities.setItemCaption(facility.getId(), facility.getFacilityName());
        }
        comboFacilities.setImmediate(true);

        comboFacilities.setWidth(250, Unit.PIXELS);

        locationLayout.addComponent(comboFacilities);


        for (LocationType locationType : locationTypes) {
            comboLocationTypes.addItem(locationType.getId());
            comboLocationTypes.setItemCaption(locationType.getId(), locationType.getName());
        }
        comboLocationTypes.setImmediate(true);
        comboLocationTypes.setWidth(250, Unit.PIXELS);


        locationLayout.setSizeFull();
        locationLayout.addComponent(comboLocationTypes);


        locationLayout.addComponent(comboLocation);

        addComponent(locationLayout);
        addComponent(new Label("<HR/>", ContentMode.HTML));

        for (Course course : courses) {
            comboCourse.addItem(course.getId());
            comboCourse.setItemCaption(course.getId(), course.getName());
        }
        comboCourse.setImmediate(true);
        comboCourse.setWidth(250, Unit.PIXELS);

        professionLayout.setSizeFull();
        professionLayout.addComponent(comboCourse);

        for (Position position : professions) {
            comboProfession.addItem(position.getId());
            comboProfession.setItemCaption(position.getId(), position.getPositionTitle());
        }
        comboProfession.setImmediate(true);
        comboProfession.setWidth(250, Unit.PIXELS);
        professionLayout.addComponent(comboProfession);

        addComponent(professionLayout);

        addComponent(new Label("<HR/>", ContentMode.HTML));
        generateReportButton.setStyleName("default");
        addComponent(generateReportButton);
        List<Report> report = new ArrayList<>();
        ReportTable table = new ReportTable(report);
        tablelayout.removeAllComponents();
        tablelayout.addComponent(table);
        addComponent(tablelayout);


    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == generateReportButton) {
            if (startDate.getValue() != null && endDate.getValue() != null) {                         
                ReportQuery query = new ReportQuery.Builder(startDate.getValue(), endDate.getValue())
                        .courseId(getStringValue(comboCourse.getValue()))
                        .facilityId(getStringValue(comboFacilities.getValue()))
                        .locationId(getStringValue(comboLocation.getValue()))
                        .locationTypeId(getStringValue(comboLocationTypes.getValue()))
                        .professionId(getStringValue(comboProfession.getValue()))
                        .build();
                List<Report> report = new PeopleData().getReportData(query);
                ReportTable table = new ReportTable(report);
                tablelayout.removeAllComponents();
                tablelayout.addComponent(table);
                addComponent(tablelayout);
                main.content.setSecondComponent(new ReportsTab(main, table));

            } else {
                Notification.show("Please, Select Date Range!", Notification.Type.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();

        if (property == comboLocationTypes) {
            String locationTypeId = property.getValue().toString();
            if (property.getValue() != null) {
                Collection<Location> locs = Collections2.filter(locations, new LocationTypePredicate(locationTypeId));
                comboLocation.removeAllItems();
                for (Location location : locs) {
                    comboLocation.addItem(location.getId());
                    comboLocation.setItemCaption(location.getId(), location.getName());
                }
                comboLocation.setImmediate(true);
                comboLocation.setWidth(250, Unit.PIXELS);
                locationLayout.addComponent(comboLocation);
            }
        }
    }

    private void addListeners() {
        //Register Button Listeners
        generateReportButton.addClickListener((Button.ClickListener) this);
        //Register Table Listerners
        comboLocationTypes.addValueChangeListener((Property.ValueChangeListener) this);
        comboLocation.addValueChangeListener((Property.ValueChangeListener) this);
        comboCourse.addValueChangeListener((Property.ValueChangeListener) this);
        comboProfession.addValueChangeListener((Property.ValueChangeListener) this);
        comboFacilities.addValueChangeListener((Property.ValueChangeListener) this);

    }

    private String getStringValue(Object value) {
        if (value != null) {
            return value.toString();
        }
        return null;
    }
    
     
}
