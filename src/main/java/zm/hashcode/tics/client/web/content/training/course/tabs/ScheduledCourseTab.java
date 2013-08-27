/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.tabs;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.ui.util.FunderFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.course.forms.ScheduledCourseForm;
import zm.hashcode.tics.client.web.content.training.course.model.ScheduledCourseBean;
import zm.hashcode.tics.client.web.content.training.course.tables.ScheduledCourseTable;
import zm.hashcode.tics.client.web.content.training.course.util.ScheduledCourseUtil;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author geek
 */
public class ScheduledCourseTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ScheduledCourseForm form;
    private final ScheduledCourseTable table;
    //
    private Collection<String> courseParticipantsIds = new HashSet<>(); // for ListSelect
    private Collection<String> courseInstructorsIds = new HashSet<>(); // for ListSelect
    private Collection<String> courseFundersIds = new HashSet<>(); // for ListSelect
    //
    private String courseId; // for and ENTITY
    private String locationId; // for and ENTITY

    public ScheduledCourseTab(TicsMain app) {
        main = app;
        form = new ScheduledCourseForm();
        table = new ScheduledCourseTable(main);
        setSizeFull();
        addComponent(form);
        addComponent(table);
        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.save) {
            saveForm(form.binder);
        } else if (source == form.edit) {
            setEditFormProperties();
        } else if (source == form.cancel) {
            getHome();
        } else if (source == form.update) {
            saveEditedForm(form.binder);
        } else if (source == form.delete) {
            deleteForm(form.binder);
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == table) {
            final ScheduledCourse scheduledCourse = ScheduledCourseFacade.getScheduledCourseService().find(table.getValue().toString());
            final ScheduledCourseBean bean = new ScheduledCourseUtil().getBean(scheduledCourse);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.courseCombo) {
            courseId = property.getValue().toString();
        } else if (property == form.locationCombo) {
            locationId = property.getValue().toString();
        } else if (property == form.courseFundersList) {
            courseFundersIds = (Collection<String>) property.getValue();
        } else if (property == form.courseInstructorsList) {
            courseInstructorsIds = (Collection<String>) property.getValue();
        }
//        else if (property == form.courseParticipantsList) {
//            courseParticipantsIds = (Collection<String>) property.getValue();
//        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            ScheduledCourseFacade.getScheduledCourseService().persist(getNewEntity(binder));
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
            ScheduledCourseFacade.getScheduledCourseService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        ScheduledCourseFacade.getScheduledCourseService().remove(getUpdateEntity(binder));
        getHome();
    }

    private ScheduledCourse getNewEntity(FieldGroup binder) {
        final ScheduledCourseBean bean = ((BeanItem<ScheduledCourseBean>) binder.getItemDataSource()).getBean();
//
        Set<Person> persons = new HashSet<>();
        for (String id : courseParticipantsIds) {
            Person uPerson = PersonFacade.getPersonService().find(id);
            persons.add(uPerson);
        }
        //
        List<TrainingInstructors> trainingInstructors = new ArrayList<>();
        for (String id : courseInstructorsIds) {
            TrainingInstructors uTrainingInstructors = TrainingInstructorsFacade.getTrainingInstructorsService().find(id);
            trainingInstructors.add(uTrainingInstructors);
        }
        //
        List<Funder> funders = new ArrayList<>();
        for (String id : courseFundersIds) {
            Funder uFunder = FunderFacade.getFunderService().find(id);
            funders.add(uFunder);
        }
        //
        Location location = LocationFacade.getLocationService().find(locationId);
        Course course = CourseFacade.getCourseService().find(courseId);

        final ScheduledCourse scheduledCourse = new ScheduledCourse.Builder(course)
                .classInstructors(trainingInstructors)
                .courseCapacity(bean.getCourseCapacity())
                .courseFunders(funders)
                .creditHours(bean.getCreditHours())
                .notes(bean.getNotes())
                .participants(persons)
                .startDate(bean.getStartDate())
                .location(location)
                .endDate(bean.getEndDate())
                .venue(bean.getVenue())
                .build();
        return scheduledCourse;
    }

    private ScheduledCourse getUpdateEntity(FieldGroup binder) {
        final ScheduledCourseBean bean = ((BeanItem<ScheduledCourseBean>) binder.getItemDataSource()).getBean();
//
        Set<Person> persons = new HashSet<>();
        for (String id : courseParticipantsIds) {
            Person uPerson = PersonFacade.getPersonService().find(id);
            persons.add(uPerson);
        }
        //
        List<TrainingInstructors> trainingInstructors = new ArrayList<>();
        for (String id : courseInstructorsIds) {
            TrainingInstructors uTrainingInstructors = TrainingInstructorsFacade.getTrainingInstructorsService().find(id);
            trainingInstructors.add(uTrainingInstructors);
        }
        //
        List<Funder> funders = new ArrayList<>();
        for (String id : courseFundersIds) {
            Funder uFunder = FunderFacade.getFunderService().find(id);
            funders.add(uFunder);
        }
        //
        Location location = LocationFacade.getLocationService().find(locationId);
        Course course = CourseFacade.getCourseService().find(courseId);

        final ScheduledCourse scheduledCourse = new ScheduledCourse.Builder(course)
                .classInstructors(trainingInstructors)
                .courseCapacity(bean.getCourseCapacity())
                .courseFunders(funders)
                .creditHours(bean.getCreditHours())
                .notes(bean.getNotes())
                .participants(persons)
                .startDate(bean.getStartDate())
                .location(location)
                .endDate(bean.getEndDate())
                .venue(bean.getVenue())
                .id(bean.getId())
                .build();
        return scheduledCourse;
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionMenu(main, "SCHEDULECOURSES"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.save.setVisible(false);
        form.edit.setVisible(false);
        form.cancel.setVisible(true);
        form.delete.setVisible(false);
        form.update.setVisible(true);
    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.save.setVisible(false);
        form.edit.setVisible(true);
        form.cancel.setVisible(true);
        form.delete.setVisible(true);
        form.update.setVisible(false);
    }

    private void addListeners() {
        //Register Button Listeners
        form.save.addClickListener((ClickListener) this);
        form.edit.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);
        form.update.addClickListener((ClickListener) this);
        form.delete.addClickListener((ClickListener) this);
        //Register Table Listerners
        table.addValueChangeListener((ValueChangeListener) this);
        //
        form.courseCombo.addValueChangeListener((ValueChangeListener) this);
        form.locationCombo.addValueChangeListener((ValueChangeListener) this);
        //
        form.courseFundersList.addValueChangeListener((ValueChangeListener) this);
        form.courseInstructorsList.addValueChangeListener((ValueChangeListener) this);
//        form.courseParticipantsList.addValueChangeListener((ValueChangeListener) this);
    }
}
