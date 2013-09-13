/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.people.EmployeeActionPlanFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.PersonActionPlanForm;
import zm.hashcode.tics.domain.people.EmployeeActionPlan;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author geek
 */
public class PersonActionPlanTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private PersonActionPlanForm form;

    public PersonActionPlanTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("Course", String.class, null);
        addContainerProperty("Schedule Course", String.class, null);
        addContainerProperty("Action Plan", String.class, null);
        addContainerProperty("Action Plan Date", Date.class, null);
        addContainerProperty("Review Plan Date", Date.class, null);
        addContainerProperty("Action Plan Review", String.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Review", CheckBox.class, null);
        addContainerProperty("Mentor Session", String.class, null);
        addContainerProperty("Nimart Session", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);


        List<EmployeeActionPlan> employeeActionPlans = person.getActionPlans();
//        int i = 1;
        for (EmployeeActionPlan employeeActionPlan : employeeActionPlans) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(employeeActionPlan);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EmployeeActionPlan itemId = (EmployeeActionPlan) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getActionPlan());

                    ////////////////////////////////
                    List<EmployeeActionPlan> updatedEmployeeActionPlans = new ArrayList<>();
                    updatedEmployeeActionPlans.addAll(person.getActionPlans());
                    updatedEmployeeActionPlans.remove(itemId);
                    ////////////////////////////////////

//                    List<EmployeeActionPlan> updatedEmployeeActionPlans = removeEntity(itemId, person.getActionPlans());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .actionPlans(updatedEmployeeActionPlans)
                            .id(person.getId())
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    EmployeeActionPlanFacade.getEmployeeActionPlanService().remove(itemId); // NOTE
                    getHome();
                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(employeeActionPlan);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EmployeeActionPlan itemIdd = (EmployeeActionPlan) event.getButton().getData();
                    form = new PersonActionPlanForm(main, person, content);
                    content.removeAllComponents();
                    form.setBean(itemIdd);
                    form.getSave().setVisible(false);
                    form.getUpdate().setVisible(true);
                    content.addComponent(form);

                }
            });

            editbutton.setStyleName(Reindeer.BUTTON_LINK);

//            i++;

            Course course = CourseFacade.getCourseService().find(employeeActionPlan.getCourseId());
            ScheduledCourse scheduledCourse = ScheduledCourseFacade.getScheduledCourseService().find(employeeActionPlan.getSchduledCourseId());
            MentoringSession mentoringSession = MentoringSessionFacade.getMentoringSessionService().find(employeeActionPlan.getMentoringSessionId());
            MentoringSession nimmartSession = MentoringSessionFacade.getMentoringSessionService().find(employeeActionPlan.getNimmartSessionId());

            addItem(new Object[]{
                course.getName(),
                scheduledCourse.getVenue() + " " + scheduledCourse.getStartDate(),
                employeeActionPlan.getActionPlan(),
                employeeActionPlan.getActionPlanDate(),
                employeeActionPlan.getReviewPlanDate(),
                employeeActionPlan.getActionPlanreview(),
                employeeActionPlan.getStatus(),
                employeeActionPlan.isReview(),
                mentoringSession.getSessionName(),
                nimmartSession.getSessionName(),
                editbutton,
                deleteButton
            }, employeeActionPlan.getId()); //   }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<EmployeeActionPlan> removeEntity(final EmployeeActionPlan employeeActionPlan, List<EmployeeActionPlan> employeeActionPlans) {
        return ImmutableList.copyOf(Collections2.filter(employeeActionPlans, Predicates.not(Predicates.equalTo(employeeActionPlan))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        PersonActionPlanTable updatetable = new PersonActionPlanTable(main, personn, content);
        content.addComponent(updatetable);

    }
    //
}
