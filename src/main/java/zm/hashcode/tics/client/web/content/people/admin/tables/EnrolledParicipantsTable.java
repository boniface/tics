/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tables;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author boniface
 */
public class EnrolledParicipantsTable extends Table {

    private final TicsMain main;

    public EnrolledParicipantsTable(final TicsMain main, String scheduledCourseId) {
        this.main = main;

        setSizeFull();

        addContainerProperty("Title", String.class, null);
        addContainerProperty("Surname", String.class, null);
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("De-Register", Button.class, null);

        final ScheduledCourse course = ScheduledCourseFacade.getScheduledCourseService().find(scheduledCourseId);

        Set<Person> personlist = course.getParticipants();
        for (Person person : personlist) {

            Button deregister = new Button("De-Register");
            deregister.setData(person.getId());
            deregister.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    String itemId = (String) event.getButton().getData();
                    Person deregister = PersonFacade.getPersonService().find(itemId);
                    Set<Person> persons = new HashSet<>();
                    persons.addAll(course.getParticipants());
                    persons.remove(deregister);

                    ScheduledCourse updatedSchedule = new ScheduledCourse.Builder(course.getCourse())
                            .scheduledCourse(course)
                            .participants(persons)
                            .build();
                    ScheduledCourseFacade.getScheduledCourseService().merge(updatedSchedule);
                    getHome();

                }
            });

            deregister.setStyleName(Reindeer.BUTTON_LINK);


            addItem(new Object[]{
                getTitle(person.getTitle()),
                person.getSurname(),
                person.getFirstname(),
                deregister
            }, person.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getTitle(Title title) {
        if (title != null) {
            return title.getTitle();
        }
        return null;
    }

    private void getHome() {
        main.content.setSecondComponent(new AdministerMenu(main, "TRAINING"));
    }
}
