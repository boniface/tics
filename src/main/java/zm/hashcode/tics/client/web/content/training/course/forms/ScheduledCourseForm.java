/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.ui.util.FunderFacade;
import zm.hashcode.tics.client.web.content.training.course.model.ScheduledCourseBean;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author geek
 */
public class ScheduledCourseForm extends FormLayout {

    private final ScheduledCourseBean bean;
    public final BeanItem<ScheduledCourseBean> item;
    public final FieldGroup binder;
    //
    public ComboBox courseCombo = new ComboBox();
    public ComboBox locationCombo = new ComboBox();
    //
//    public ListSelect courseParticipantsList = new ListSelect();
    public ListSelect courseInstructorsList = new ListSelect();
    public ListSelect courseFundersList = new ListSelect();
    //
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
//

    public ScheduledCourseForm() {
        bean = new ScheduledCourseBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        //
        final TextArea venueTextField = getTextArea("Venue", "venue");
        final TextArea notesTextArea = getTextArea("Notes", "notes");
        final TextField courseCapacityTextField = getTextField("Course Capacity", "courseCapacity");
        final TextField creditHoursTextField = getTextField("Credit Hours", "creditHours");
        final PopupDateField startDatePopupDateField = getPopupDateField("Start Date", "startDate");
        final PopupDateField endDatePopupDateField = getPopupDateField("End Date", "endDate");
        final ComboBox courseComboBox = getCourseComboBox("Course", "courseId");
        final ComboBox locationComboBox = getlocationComboBox("Location", "locationId");
        final ListSelect trainingInstructorsListSelect = getCourseInstructorsListSelect("Training Instructors", "trainingInstructorsIds");
        final ListSelect courseFundersListSelect = getCourseFundersListSelect("Course Funders", "fundersIds");
        //
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(courseComboBox, 0, 0);
        grid.addComponent(startDatePopupDateField, 1, 0);
        grid.addComponent(endDatePopupDateField, 2, 0);

        grid.addComponent(courseCapacityTextField, 0, 1);
        grid.addComponent(creditHoursTextField, 1, 1);
        grid.addComponent(locationComboBox, 2, 1);

        grid.addComponent(venueTextField, 0, 2, 0, 3);
        grid.addComponent(notesTextArea, 1, 2, 1, 3);

        grid.addComponent(trainingInstructorsListSelect, 0, 4, 0, 5);
        grid.addComponent(courseFundersListSelect, 1, 4, 1, 5);


        grid.addComponent(buttons, 0, 6, 2, 6);

        addComponent(grid);
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(ScheduledCourseBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private TextArea getTextArea(String label, String field) {
        TextArea textArea = new TextArea(label);
        textArea.setWidth(250, Unit.PIXELS);
        textArea.setNullRepresentation("");
        textArea.addValidator(new BeanValidator(ScheduledCourseBean.class, field));
        textArea.setImmediate(true);
        binder.bind(textArea, field);
        return textArea;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(ScheduledCourseBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getCourseComboBox(String label, String field) {
        courseCombo.setCaption(label);
        List<Course> courses = CourseFacade.getCourseService().findAll();
        for (Course iCourse : courses) {
            courseCombo.addItem(iCourse.getId());
            courseCombo.setItemCaption(iCourse.getId(), iCourse.getName());
        }
        courseCombo.addValidator(new BeanValidator(ScheduledCourseBean.class, field));
        courseCombo.setImmediate(true);
        courseCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseCombo, field);
        return courseCombo;
    }

    private ComboBox getlocationComboBox(String label, String field) {
        locationCombo.setCaption(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
        for (Location iLocation : locations) {
            locationCombo.addItem(iLocation.getId());
            locationCombo.setItemCaption(iLocation.getId(), iLocation.getName());
        }
        locationCombo.addValidator(new BeanValidator(ScheduledCourseBean.class, field));
        locationCombo.setImmediate(true);
        locationCombo.setWidth(250, Unit.PIXELS);
        binder.bind(locationCombo, field);
        return locationCombo;
    }

//    private ListSelect getCourseParticipantsListSelect(String label, String field) {
//        courseParticipantsList.setCaption(label);
//        List<Person> persons = PersonFacade.getPersonService().findAll();
//        for (Person iPerson : persons) {
//            courseParticipantsList.setItemCaption(iPerson.getId(), iPerson.getFirstname() + " " + iPerson.getOthername() + " " + iPerson.getSurname());
//            courseParticipantsList.setNullSelectionAllowed(false);
//            courseParticipantsList.setMultiSelect(true);
//            courseParticipantsList.addItem(iPerson.getId());
//        }
//        courseParticipantsList.setWidth("250px");
//        binder.bind(courseParticipantsList, field);
//
//        return courseParticipantsList;
//    }
    private ListSelect getCourseInstructorsListSelect(String label, String field) {
        courseInstructorsList.setCaption(label);
        List<TrainingInstructors> trainingInstructors = TrainingInstructorsFacade.getTrainingInstructorsService().findAll();
        for (TrainingInstructors uTrainingInstructor : trainingInstructors) {
            courseInstructorsList.setItemCaption(uTrainingInstructor.getId(), uTrainingInstructor.getFirstName() + " " + uTrainingInstructor.getOtherName() + " " + uTrainingInstructor.getLastName());
            courseInstructorsList.setNullSelectionAllowed(false);
            courseInstructorsList.setMultiSelect(true);
            courseInstructorsList.addItem(uTrainingInstructor.getId());
        }
        courseInstructorsList.setWidth("250px");
        binder.bind(courseInstructorsList, field);

        return courseInstructorsList;
    }

    private ListSelect getCourseFundersListSelect(String label, String field) {
        courseFundersList.setCaption(label);
        List<Funder> funders = FunderFacade.getFunderService().findAll();
        for (Funder uFunder : funders) {
            courseFundersList.setItemCaption(uFunder.getId(), uFunder.getTrainingFunderName());
            courseFundersList.setNullSelectionAllowed(false);
            courseFundersList.setMultiSelect(true);
            courseFundersList.addItem(uFunder.getId());
        }
        courseFundersList.setWidth("250px");
        binder.bind(courseFundersList, field);

        return courseFundersList;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        return buttons;
    }
}
