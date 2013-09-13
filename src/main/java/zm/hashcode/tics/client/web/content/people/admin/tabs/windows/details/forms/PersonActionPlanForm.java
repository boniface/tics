/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.people.EmployeeActionPlanFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringSessionFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.PersonActionPlanBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.PersonActionPlanTable;
import zm.hashcode.tics.domain.people.EmployeeActionPlan;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;

/**
 *
 * @author geek
 */
public class PersonActionPlanForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final PersonActionPlanBean bean;
    public final BeanItem<PersonActionPlanBean> item;
    public final FieldGroup binder;
    //
    public ComboBox courseCombo = new ComboBox();
    public ComboBox scheduledCourseCombo = new ComboBox();
    public ComboBox mentoringSessionCombo = new ComboBox();
    public ComboBox nimmartSessionCombo = new ComboBox();
    /*
     private String courseComboId; // for and ENTITY
     private String scheduledCourseComboId; // for and ENTITY
     private String mentoringSessionComboId; // for and ENTITY
     private String nimmartSessionComboId; // for and ENTITY
     */
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private PersonActionPlanTable table;

    public PersonActionPlanForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;


        bean = new PersonActionPlanBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        final ComboBox courseIdComboBox = getCourseIdComboBox("Course", "courseId");
        final ComboBox scheduledCourseIdComboBox = getScheduledCourseIdComboBox("Scheduled Course", "schduledCourseId");
        final TextField actionPlan = getTextField("Action Plan", "actionPlan");
        final PopupDateField actionPlanPopupDateField = getPopupDateField("Action Plan Date", "actionPlanDate");
        final PopupDateField reviewPlanPopupDateField = getPopupDateField("Review Plan Date", "reviewPlanDate");
        final TextField actionPlanReviewTextField = getTextField("Action Plan Review", "actionPlanreview");
        final TextField statusTextField = getTextField("Status", "status");
        final CheckBox reviewCheckBox = getCheckBoxField("Review?", "review");
        final ComboBox mentoringSessionIdComboBox = getMentoringSessionIdComboBox("Mentoring Session", "mentoringSessionId");
        final ComboBox nimmartSessionIdComboBox = getNimmartSessionIdComboBox("Nimmart Session", "nimmartSessionId");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(courseIdComboBox, 0, 0);
        grid.addComponent(scheduledCourseIdComboBox, 1, 0);
        grid.addComponent(actionPlan, 2, 0);
        grid.addComponent(actionPlanReviewTextField, 3, 0);

        grid.addComponent(actionPlanPopupDateField, 0, 1);
        grid.addComponent(reviewPlanPopupDateField, 1, 1);
        grid.addComponent(mentoringSessionIdComboBox, 2, 1);
        grid.addComponent(nimmartSessionIdComboBox, 3, 1);

        grid.addComponent(statusTextField, 0, 2);
        grid.addComponent(reviewCheckBox, 1, 2);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
        addListeners();

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getCourseIdComboBox(String label, String field) {
        courseCombo.setCaption(label);
        List<Course> courses = CourseFacade.getCourseService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());
        for (Course course : courses) {
            courseCombo.addItem(course.getId());
            courseCombo.setItemCaption(course.getId(), course.getName());
        }
        courseCombo.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        courseCombo.setImmediate(true);
        courseCombo.setWidth(250, Unit.PIXELS);
        binder.bind(courseCombo, field);
        return courseCombo;
    }

    private ComboBox getScheduledCourseIdComboBox(String label, String field) {
        scheduledCourseCombo.setCaption(label);
        List<ScheduledCourse> scheduledCourses = ScheduledCourseFacade.getScheduledCourseService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());
        for (ScheduledCourse scheduledCourse : scheduledCourses) {
            scheduledCourseCombo.addItem(scheduledCourse.getId());
            scheduledCourseCombo.setItemCaption(scheduledCourse.getId(), scheduledCourse.getVenue() + " " + scheduledCourse.getStartDate() + "-" + scheduledCourse.getEndDate());
        }
        scheduledCourseCombo.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        scheduledCourseCombo.setImmediate(true);
        scheduledCourseCombo.setWidth(250, Unit.PIXELS);
        binder.bind(scheduledCourseCombo, field);
        return scheduledCourseCombo;
    }

    private ComboBox getMentoringSessionIdComboBox(String label, String field) {
        mentoringSessionCombo.setCaption(label);
        List<MentoringSession> mentoringSessions = MentoringSessionFacade.getMentoringSessionService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());
        for (MentoringSession mentoringSession : mentoringSessions) {
            mentoringSessionCombo.addItem(mentoringSession.getId());
            mentoringSessionCombo.setItemCaption(mentoringSession.getId(), mentoringSession.getSessionName());
        }
        mentoringSessionCombo.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        mentoringSessionCombo.setImmediate(true);
        mentoringSessionCombo.setWidth(250, Unit.PIXELS);
        binder.bind(mentoringSessionCombo, field);
        return mentoringSessionCombo;
    }

    private ComboBox getNimmartSessionIdComboBox(String label, String field) {
        nimmartSessionCombo.setCaption(label);
        List<MentoringSession> mentoringSessions = MentoringSessionFacade.getMentoringSessionService().findAll();
//        Collection<TrainingInstitution> institutionCourses = Collections2.filter(trainingInstitutions, new TrainingInstitutionPredicate());
        for (MentoringSession mentoringSession : mentoringSessions) {
            nimmartSessionCombo.addItem(mentoringSession.getId());
            nimmartSessionCombo.setItemCaption(mentoringSession.getId(), mentoringSession.getSessionName());
        }
        nimmartSessionCombo.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        nimmartSessionCombo.setImmediate(true);
        nimmartSessionCombo.setWidth(250, Unit.PIXELS);
        binder.bind(nimmartSessionCombo, field);
        return nimmartSessionCombo;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
    }

    private CheckBox getCheckBoxField(String label, String field) {
        CheckBox checkBox = new CheckBox(label);
        checkBox.setWidth(250, Unit.PIXELS);
        checkBox.addValidator(new BeanValidator(PersonActionPlanBean.class, field));
        checkBox.setImmediate(true);
        binder.bind(checkBox, field);
        return checkBox;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == save) {
            saveForm(binder);
        } else if (source == cancel) {
            getHome();
        } else if (source == update) {
            saveEditedForm(binder);
        } else if (source == delete) {
            deleteForm(binder);
        }
    }

    private void addListeners() {
        //Register Button Listeners
        save.addClickListener((Button.ClickListener) this);
        cancel.addClickListener((Button.ClickListener) this);
        update.addClickListener((Button.ClickListener) this);
        delete.addClickListener((Button.ClickListener) this);
//        table.addValueChangeListener((Property.ValueChangeListener) this); // add later in getHOme()
        /*
         courseCombo.addValueChangeListener((Property.ValueChangeListener) this);
         scheduledCourseCombo.addValueChangeListener((Property.ValueChangeListener) this);
         mentoringSessionCombo.addValueChangeListener((Property.ValueChangeListener) this);
         nimmartSessionCombo.addValueChangeListener((Property.ValueChangeListener) this);
         */
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            EmployeeActionPlan employeeActionPlan = getNewEntity(binder);
            EmployeeActionPlanFacade.getEmployeeActionPlanService().persist(employeeActionPlan);
            List<EmployeeActionPlan> employeeActionPlans = new ArrayList<>();
            employeeActionPlans.add(employeeActionPlan);
            employeeActionPlans.addAll(person.getActionPlans());
            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                    .person(person)
                    .actionPlans(employeeActionPlans)
                    .id(person.getId())
                    .build();
            PersonFacade.getPersonService().merge(updatePerson);
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void saveEditedForm(FieldGroup binder) {
        try {
            binder.commit();
            EmployeeActionPlan employeeActionPlan = getUpdateEntity(binder);
            EmployeeActionPlanFacade.getEmployeeActionPlanService().merge(employeeActionPlan);
            List<EmployeeActionPlan> employeeActionPlans = new ArrayList<>();
            employeeActionPlans.addAll(person.getActionPlans());
            employeeActionPlans.add(employeeActionPlan);

            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                    .person(person)
                    .actionPlans(employeeActionPlans)
                    .id(person.getId())
                    .build();
            PersonFacade.getPersonService().merge(updatePerson);
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        getHome();
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId()); // Get Person with current changes // refresh
        table = new PersonActionPlanTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private EmployeeActionPlan getNewEntity(FieldGroup binder) {
        final PersonActionPlanBean entityBean = ((BeanItem<PersonActionPlanBean>) binder.getItemDataSource()).getBean();
        final EmployeeActionPlan employeeActionPlan = new EmployeeActionPlan.Builder(entityBean.getActionPlan())
                .actionPlanDate(entityBean.getActionPlanDate())
                .actionPlanreview(entityBean.getActionPlanreview())
                .courseId(entityBean.getCourseId())
                .mentoringSessionId(entityBean.getMentoringSessionId())
                .nimmartSessionId(entityBean.getNimmartSessionId())
                .review(entityBean.isReview())
                .reviewPlanDate(entityBean.getReviewPlanDate())
                .schduledCourseId(entityBean.getSchduledCourseId())
                .status(entityBean.getStatus())
                .build();
        return employeeActionPlan;
    }

    private EmployeeActionPlan getUpdateEntity(FieldGroup binder) {
        final PersonActionPlanBean entityBean = ((BeanItem<PersonActionPlanBean>) binder.getItemDataSource()).getBean();
        final EmployeeActionPlan employeeActionPlan = new EmployeeActionPlan.Builder(entityBean.getActionPlan())
                .actionPlanDate(entityBean.getActionPlanDate())
                .actionPlanreview(entityBean.getActionPlanreview())
                .courseId(entityBean.getCourseId())
                .mentoringSessionId(entityBean.getMentoringSessionId())
                .nimmartSessionId(entityBean.getNimmartSessionId())
                .review(entityBean.isReview())
                .reviewPlanDate(entityBean.getReviewPlanDate())
                .schduledCourseId(entityBean.getSchduledCourseId())
                .status(entityBean.getStatus())
                .id(entityBean.getId())
                .build();
        return employeeActionPlan;

    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
        /*
         if (property == this.courseCombo) {
         courseComboId = property.getValue().toString();
         } else if (property == this.scheduledCourseCombo) {
         scheduledCourseComboId = property.getValue().toString();
         } else if (property == this.mentoringSessionCombo) {
         mentoringSessionComboId = property.getValue().toString();
         } else if (property == this.nimmartSessionCombo) {
         nimmartSessionComboId = property.getValue().toString();
         }
         * */
    }

    public void setBean(EmployeeActionPlan employeeActionPlan) {
        item.getBean().setId(employeeActionPlan.getId());
        item.getBean().setActionPlan(employeeActionPlan.getActionPlan());
        item.getBean().setActionPlanDate(employeeActionPlan.getActionPlanDate());
        item.getBean().setActionPlanreview(employeeActionPlan.getActionPlanreview());
        item.getBean().setCourseId(employeeActionPlan.getCourseId());
        item.getBean().setMentoringSessionId(employeeActionPlan.getMentoringSessionId());
        item.getBean().setNimmartSessionId(employeeActionPlan.getNimmartSessionId());
        item.getBean().setReview(employeeActionPlan.isReview());
        item.getBean().setReviewPlanDate(employeeActionPlan.getReviewPlanDate());
        item.getBean().setSchduledCourseId(employeeActionPlan.getSchduledCourseId());
        item.getBean().setStatus(employeeActionPlan.getStatus());
    }

    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @return the save
     */
    public Button getSave() {
        return save;
    }
}
