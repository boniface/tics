/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.traininginstitution.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.content.system.traininginstitution.model.TrainingInstitutionBean;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author geek
 */
public class TrainingInstitutionForm extends FormLayout {

    private final TrainingInstitutionBean bean;
    public final BeanItem<TrainingInstitutionBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    //
    public ComboBox locationCombo = new ComboBox();
    public ListSelect usersList = new ListSelect();
    public ListSelect trainingInstructorsList = new ListSelect();
    public ListSelect coursesList = new ListSelect();
    public ListSelect scheduledCoursesList = new ListSelect();

    public TrainingInstitutionForm() {
        bean = new TrainingInstitutionBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField name = getTextField("Name", "name");
        ComboBox location = getLocationComboBox("City", "locationId");
        final ListSelect usersIds = getUsersListSelect("Select Users", "usersIds");
        final ListSelect trainingInstructorsIds = getTrainingInstructorsListSelect("Select Training Instructors", "trainingInstructorsIds");
        final ListSelect coursesIds = getCoursesListSelect("Select Courses", "coursesIds");
        final ListSelect scheduledCoursesIds = getScheduledCoursesListSelect("Select Scheduled Courses", "scheduledCoursesIds");

        GridLayout grid = new GridLayout(4, 10);  // ADJUSTS if neccesary Col, Row
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(location, 1, 0);
        grid.addComponent(usersIds, 0, 1);
        grid.addComponent(trainingInstructorsIds, 1, 1);
        grid.addComponent(coursesIds, 2, 1);
        grid.addComponent(scheduledCoursesIds, 3, 1);

        grid.addComponent(buttons, 0, 4, 2, 4);

        addComponent(grid);

    }

    private ListSelect getUsersListSelect(String label, String field) {
        usersList.setCaption(label);
        List<User> users = UserFacade.getUserService().findAll();
        for (User iUser : users) {
            usersList.setItemCaption(iUser.getId(), iUser.getFirstname() + " " + iUser.getLastname());
            usersList.setNullSelectionAllowed(false);
            usersList.setMultiSelect(true);
            usersList.addItem(iUser.getId());
        }
        usersList.setWidth("250px");
        binder.bind(usersList, field);

        return usersList;
    }

    private ListSelect getTrainingInstructorsListSelect(String label, String field) {
        trainingInstructorsList.setCaption(label);
        List<TrainingInstructors> trainingInstructors = TrainingInstructorsFacade.getTrainingInstructorsService().findAll();
        for (TrainingInstructors iTrainingInstructors : trainingInstructors) {
            trainingInstructorsList.setItemCaption(iTrainingInstructors.getId(), iTrainingInstructors.getFirstName() + " " + iTrainingInstructors.getLastName());
            trainingInstructorsList.setNullSelectionAllowed(false);
            trainingInstructorsList.setMultiSelect(true);
            trainingInstructorsList.addItem(iTrainingInstructors.getId());
        }
        trainingInstructorsList.setWidth("250px");
        binder.bind(trainingInstructorsList, field);

        return trainingInstructorsList;
    }

    private ListSelect getCoursesListSelect(String label, String field) {
        coursesList.setCaption(label);
        List<Course> Courses = CourseFacade.getCourseService().findAll();
        for (Course iCourse : Courses) {
            coursesList.setItemCaption(iCourse.getId(), iCourse.getName());
            coursesList.setNullSelectionAllowed(false);
            coursesList.setMultiSelect(true);
            coursesList.addItem(iCourse.getId());
        }
        coursesList.setWidth("250px");
        binder.bind(coursesList, field);

        return coursesList;
    }

    private ListSelect getScheduledCoursesListSelect(String label, String field) {
        scheduledCoursesList.setCaption(label);
        List<ScheduledCourse> scheduledCourses = ScheduledCourseFacade.getScheduledCourseService().findAll();
        for (ScheduledCourse iScheduledCourse : scheduledCourses) {
            scheduledCoursesList.setItemCaption(iScheduledCourse.getId(), iScheduledCourse.getVenue() + " " + iScheduledCourse.getNotes());
            scheduledCoursesList.setNullSelectionAllowed(false);
            scheduledCoursesList.setMultiSelect(true);
            scheduledCoursesList.addItem(iScheduledCourse.getId());
        }
        scheduledCoursesList.setWidth("250px");
        binder.bind(scheduledCoursesList, field);

        return scheduledCoursesList;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getLocationComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        locationCombo.setCaption(label);
        List<Location> allLocations = LocationFacade.getLocationService().findAll();
        for (Location iLocation : allLocations) {
            locationCombo.addItem(iLocation.getId());
            locationCombo.setItemCaption(iLocation.getId(), iLocation.getName());
        }

//        List<Location> locations = LocationFacade.getLocationModelService().findAll();
//
////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
//
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
//        for (Location location : cities) {
//            comboBox.addItem(location.getId());
//            comboBox.setItemCaption(location.getId(), location.getName());
//        }
        locationCombo.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
        locationCombo.setImmediate(true);
        locationCombo.setWidth(250, Unit.PIXELS);
        binder.bind(locationCombo, field);
        return locationCombo;
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
