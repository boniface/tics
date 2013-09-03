/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tabs;

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
import java.util.List;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.institutions.forms.TrainingInstructorForm;
import zm.hashcode.tics.client.web.content.training.institutions.model.TrainingInstructorBean;
import zm.hashcode.tics.client.web.content.training.institutions.tables.TrainingInstructorTable;
import zm.hashcode.tics.client.web.content.training.institutions.util.TrainingInstructorUtil;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;

/**
 *
 * @author geek
 */
public class TrainingInstructorsTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final TrainingInstructorForm form;
    private final TrainingInstructorTable table;

    public TrainingInstructorsTab(TicsMain app) {
        main = app;
        form = new TrainingInstructorForm();
        table = new TrainingInstructorTable(main);
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
            final TrainingInstructors trainingInstructors = TrainingInstructorsFacade.getTrainingInstructorsService().find(table.getValue().toString());
            final TrainingInstructorBean bean = new TrainingInstructorUtil().getBean(trainingInstructors);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TrainingInstructors trainingInstructors = getNewEntity(binder);
            TrainingInstructorsFacade.getTrainingInstructorsService().persist(trainingInstructors);

            List<TrainingInstructors> inst = new ArrayList<>();
            TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();
            inst.add(trainingInstructors);
            inst.addAll(trainingInstitution.getTrainingInstructors());
            TrainingInstitution updatedTrainingInstitution = new TrainingInstitution.Builder(trainingInstitution.getName())
                    .trainingInstitution(trainingInstitution)
                    .trainingInstructors(inst)
                    .build();
            TrainingInstitutionFacade.getTrainingInstitutionService().merge(updatedTrainingInstitution);

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
            TrainingInstructorsFacade.getTrainingInstructorsService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        final TrainingInstructors trainingInstructors = getUpdateEntity(binder);
        TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();
        trainingInstitution.getTrainingInstructors().remove(trainingInstructors);
        //add Immutability here
        TrainingInstitutionFacade.getTrainingInstitutionService().merge(trainingInstitution);
        TrainingInstructorsFacade.getTrainingInstructorsService().remove(getUpdateEntity(binder));

        getHome();
    }

    private TrainingInstructors getNewEntity(FieldGroup binder) {
        final TrainingInstructorBean bean = ((BeanItem<TrainingInstructorBean>) binder.getItemDataSource()).getBean();

        final TrainingInstructors trainingInstructor = new TrainingInstructors.Builder(bean.getLastName())
                .areaOfexpertise(bean.getAreaOfexpertise())
                .firstName(bean.getFirstName())
                .otherName(bean.getOtherName())
                .qualification(bean.getQualification())
                .build();
        return trainingInstructor;
    }

    private TrainingInstructors getUpdateEntity(FieldGroup binder) {
        final TrainingInstructorBean bean = ((BeanItem<TrainingInstructorBean>) binder.getItemDataSource()).getBean();

        final TrainingInstructors trainingInstructor = new TrainingInstructors.Builder(bean.getLastName())
                .areaOfexpertise(bean.getAreaOfexpertise())
                .firstName(bean.getFirstName())
                .otherName(bean.getOtherName())
                .qualification(bean.getQualification())
                .id(bean.getId())
                .build();
        return trainingInstructor;
    }

    private void getHome() {
        main.content.setSecondComponent(new InstitutionMenu(main, "LANDING"));
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
    }
}
