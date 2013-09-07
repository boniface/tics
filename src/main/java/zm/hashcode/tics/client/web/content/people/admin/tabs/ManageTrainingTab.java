/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.VerticalLayout;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.client.web.content.people.admin.tables.AllScheduledCourseTable;
import zm.hashcode.tics.client.web.content.people.admin.tables.EnrolledParicipantsTable;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author boniface
 */
public class ManageTrainingTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private Collection<String> participantsId;
    private String schduledCourseId;
    private final AllScheduledCourseTable table;
    final TwinColSelect select = new TwinColSelect();
    private final Button enrollPeople = new Button("Enroll Into Training Program");
    private HorizontalLayout enrollLayout = new HorizontalLayout();
    private EnrolledParicipantsTable enrolledParicipantsTable;
    private HorizontalLayout enrollPanel = new HorizontalLayout();

    public ManageTrainingTab(TicsMain main) {
        setSizeFull();
        enrollLayout.setSizeFull();
        enrollPanel.setSizeFull();
        enrollPeople.setStyleName("default");
        enrollPeople.setSizeFull();
        enrollPeople.addClickListener((Button.ClickListener) this);




        List<Person> people = PersonFacade.getPeople();

        this.main = main;
        table = new AllScheduledCourseTable(main);
        select.setLeftColumnCaption("Select Participants");
        select.setRightColumnCaption(" Enrolled Participants");
        select.setSizeFull();
        select.setImmediate(true);
        select.setNewItemsAllowed(false);
        select.addValueChangeListener((Property.ValueChangeListener) this);
        table.addValueChangeListener((Property.ValueChangeListener) this);
        select.setNullSelectionAllowed(false);
        select.setMultiSelect(true);


        for (Person person : people) {
            select.addItem(person.getId());
            select.setItemCaption(person.getId(), person.getSurname() + " " + person.getFirstname());
        }


        addComponent(table);
        enrollLayout.addComponent(select);
        enrollLayout.addComponent(enrollPanel);
        addComponent(enrollLayout);

        addComponent(enrollPeople);


    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == enrollPeople) {

            if (schduledCourseId != null) {
                enrollPArticipants(schduledCourseId, participantsId);
                getHome();
            } else {
                Notification.show("Please Select Course Schedule", Notification.Type.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == select) {
            Collection<String> ids = (Collection<String>) property.getValue();
            participantsId = ids;
        }
        if (property == table) {
            String scId = (String) property.getValue();
            schduledCourseId = scId;
            enrollPanel.removeAllComponents();
            enrolledParicipantsTable = new EnrolledParicipantsTable(main, scId);
            enrolledParicipantsTable.setCaption("Enrolled Participants");
            enrollPanel.addComponent(enrolledParicipantsTable);
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new AdministerMenu(main, "TRAINING"));
    }

    private void enrollPArticipants(String schduledCourseId, Collection<String> participantsId) {
        Set<Person> participants = new HashSet<>();
        ScheduledCourse scheduledCourse = ScheduledCourseFacade.getScheduledCourseService().find(schduledCourseId);
        for (String id : participantsId) {
            Person p = PersonFacade.getPersonService().find(id);
            participants.add(p);
        }
        participants.addAll(scheduledCourse.getParticipants());
        ScheduledCourse updateScheduledCourse = new ScheduledCourse.Builder(scheduledCourse.getCourse())
                .scheduledCourse(scheduledCourse)
                .participants(participants)
                .build();

        ScheduledCourseFacade.getScheduledCourseService().merge(updateScheduledCourse);
    }
}
