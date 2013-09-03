/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.training.tabs;

import zm.hashcode.tics.client.web.content.users.tabs.*;
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
import zm.hashcode.tics.app.facade.training.course.CourseFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.app.facade.training.schedule.ScheduledCourseFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.training.TrainingSetupMenu;
import zm.hashcode.tics.client.web.content.system.training.forms.TrainingInstitutionForm;
import zm.hashcode.tics.client.web.content.system.training.model.TrainingInstitutionBean;
import zm.hashcode.tics.client.web.content.system.training.tables.TrainingInstitutionTable;
import zm.hashcode.tics.client.web.content.system.training.util.TrainingInstitutionUtil;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author Ferox
 */
public final class TrainingInstitutionTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final TrainingInstitutionForm form;
    private final TrainingInstitutionTable table;
//    private String locationIds;
    private Collection<String> usersListIds = new HashSet<>();
//    private Collection<String> coursesListIds = new HashSet<>();
//    private Collection<String> scheduledCoursesListIds = new HashSet<>();
//    private Collection<String> trainingInstructorsListIds = new HashSet<>();
//    private Collection<String> institutionAddressesListIds = new HashSet<>();

    public TrainingInstitutionTab(TicsMain app) {
        main = app;
        form = new TrainingInstitutionForm();
        table = new TrainingInstitutionTable(main);
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
            final TrainingInstitution trainingInstitution = TrainingInstitutionFacade.getTrainingInstitutionService().find(table.getValue().toString());
            final TrainingInstitutionBean bean = new TrainingInstitutionUtil().getBean(trainingInstitution);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } //        else if (property == form.coursesList) {
        //            coursesListIds = (Collection<String>) property.getValue();
        //        } else if (property == form.scheduledCoursesList) {
        //            scheduledCoursesListIds = (Collection<String>) property.getValue();
        //        } else if (property == form.trainingInstructorsList) {
        //            trainingInstructorsListIds = (Collection<String>) property.getValue();
        //        }
        //        } else if (property == form.institutionAddressesListSelect) {
        //            institutionAddressesListIds = (Collection<String>) property.getValue();
        //        }
        else if (property == form.usersList) {
            usersListIds = (Collection<String>) property.getValue();
        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TrainingInstitutionFacade.getTrainingInstitutionService().persist(getNewEntity(binder));
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
            TrainingInstitutionFacade.getTrainingInstitutionService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TrainingInstitutionFacade.getTrainingInstitutionService().remove(getUpdateEntity(binder));
        getHome();
    }

    private TrainingInstitution getNewEntity(FieldGroup binder) {
        final TrainingInstitutionBean bean = ((BeanItem<TrainingInstitutionBean>) binder.getItemDataSource()).getBean();

        List<User> users = new ArrayList<>();
        for (String id : usersListIds) {
            User user = UserFacade.getUserService().find(id);
            users.add(user);
        }

//        List<Course> courses = new ArrayList<>();
//        for (String id : coursesListIds) {
//            Course course = CourseFacade.getCourseService().find(id);
//            courses.add(course);
//        }
//
//        List<ScheduledCourse> scheduledCourses = new ArrayList<>();
//        for (String id : scheduledCoursesListIds) {
//            ScheduledCourse scheduledCourse = ScheduledCourseFacade.getScheduledCourseService().find(id);
//            scheduledCourses.add(scheduledCourse);
//        }
//
//        List<TrainingInstructors> trainingInstructors = new ArrayList<>();
//        for (String id : trainingInstructorsListIds) {
//            TrainingInstructors trainingInstructor = TrainingInstructorsFacade.getTrainingInstructorsService().find(id);
//            trainingInstructors.add(trainingInstructor);
//        }

//        List<InstitutionAddress> InstitutionAddresses = new ArrayList<>();
//        for (String id : institutionAddressesListIds) {
//            InstitutionAddress institutionAddress = InstitutionAddressFacade.getInstitutionAddressService().find(id);
//            InstitutionAddresses.add(institutionAddress);
//        }
//
        final TrainingInstitution trainingInstitution = new TrainingInstitution.Builder(bean.getName())
                //                .courses(courses)
                //                .scheduledCourseses(scheduledCourses)
                //                .institutionAddress(InstitutionAddresses)
                .users(users)
                .build();
        return trainingInstitution;
    }

    private TrainingInstitution getUpdateEntity(FieldGroup binder) {
        final TrainingInstitutionBean bean = ((BeanItem<TrainingInstitutionBean>) binder.getItemDataSource()).getBean();

        List<User> users = new ArrayList<>();
        for (String id : usersListIds) {
            User user = UserFacade.getUserService().find(id);
            users.add(user);
        }

        final TrainingInstitution trainingInstitution = new TrainingInstitution.Builder(bean.getName())
                .users(users)
                .id(bean.getId())
                .build();
        return trainingInstitution;
    }

    private void getHome() {
        main.content.setSecondComponent(new TrainingSetupMenu(main, "LANDING"));
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
//        form.coursesList.addValueChangeListener((ValueChangeListener) this);
//        form.scheduledCoursesList.addValueChangeListener((ValueChangeListener) this);
//        form.trainingInstructorsList.addValueChangeListener((ValueChangeListener) this);
        form.usersList.addValueChangeListener((ValueChangeListener) this);
//        form.institutionAddressesListSelect.addValueChangeListener((ValueChangeListener) this);

    }
}
