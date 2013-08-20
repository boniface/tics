/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tabs;

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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.app.facade.ui.job.JobClassificationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.positions.PositionsMenu;
import zm.hashcode.tics.client.web.content.system.positions.forms.JobClassificationForm;
import zm.hashcode.tics.client.web.content.system.positions.model.JobClassificationBean;
import zm.hashcode.tics.client.web.content.system.positions.tables.JobClassificationTable;
import zm.hashcode.tics.client.web.content.system.positions.util.JobClassificationUtil;
import zm.hashcode.tics.domain.ui.job.JobClassification;

/**
 *
 * @author Ferox
 */
public final class JobClassificationTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final JobClassificationForm form;
    private final JobClassificationTable table;

    public JobClassificationTab(TicsMain app) {
        main = app;
        form = new JobClassificationForm();
        table = new JobClassificationTable(main);
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
            final JobClassification jobClassification = JobClassificationFacade.getJobClassificationService().find(table.getValue().toString());
            final JobClassificationBean bean = new JobClassificationUtil().getBean(jobClassification);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobClassificationFacade.getJobClassificationService().persist(getNewEntity(binder));
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
            JobClassificationFacade.getJobClassificationService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        JobClassificationFacade.getJobClassificationService().remove(getUpdateEntity(binder));
        getHome();
    }

    private JobClassification getNewEntity(FieldGroup binder) {
        final JobClassificationBean bean = ((BeanItem<JobClassificationBean>) binder.getItemDataSource()).getBean();

        final JobClassification jobClassification = new JobClassification.Builder(bean.getCurrentTitle())
                .codeConversion(bean.getCodeConversion())
                .comment(bean.getComment())
                .currentCode(bean.getCurrentCode())
                .oldCode(bean.getOldCode())
                .oldTitle(bean.getOldTitle())
                .build();
        return jobClassification;
    }

    private JobClassification getUpdateEntity(FieldGroup binder) {

        final JobClassificationBean bean = ((BeanItem<JobClassificationBean>) binder.getItemDataSource()).getBean();

        final JobClassification jobClassification = new JobClassification.Builder(bean.getCurrentTitle())
                .codeConversion(bean.getCodeConversion())
                .comment(bean.getComment())
                .currentCode(bean.getCurrentCode())
                .oldCode(bean.getOldCode())
                .oldTitle(bean.getOldTitle())
                .id(bean.getId())
                .build();
        return jobClassification;
    }

    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "LANDING"));
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
