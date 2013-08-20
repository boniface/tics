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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.ui.job.JobClassificationFacade;
import zm.hashcode.tics.app.facade.ui.job.JobFacade;
import zm.hashcode.tics.app.facade.ui.position.PositionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.positions.PositionsMenu;
import zm.hashcode.tics.client.web.content.system.positions.forms.JobForm;
import zm.hashcode.tics.client.web.content.system.positions.model.JobBean;
import zm.hashcode.tics.client.web.content.system.positions.tables.JobTable;
import zm.hashcode.tics.client.web.content.system.positions.util.JobUtil;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.job.JobClassification;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author Ferox
 */
public final class JobTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final JobForm form;
    private final JobTable table;
    private Collection<String> positionIds = new HashSet<>();
    private String jobClassificationComboId;

    public JobTab(TicsMain app) {
        main = app;
        form = new JobForm();
        table = new JobTable(main);
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
            final Job job = JobFacade.getJobService().find(table.getValue().toString());
            final JobBean bean = new JobUtil().getBean(job);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.positionList) {
            positionIds = (Collection<String>) property.getValue();
        } else if (property == form.jobClassificationCombo) {
            jobClassificationComboId = property.getValue().toString();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            JobFacade.getJobService().persist(getNewEntity(binder));
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
            JobFacade.getJobService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        JobFacade.getJobService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Job getNewEntity(FieldGroup binder) {
        final JobBean bean = ((BeanItem<JobBean>) binder.getItemDataSource()).getBean();

        List<Position> positions = new ArrayList<>();
        for (String id : positionIds) {
            Position position = PositionFacade.getPositionService().find(id);
            positions.add(position);
        }

        JobClassification jobClassification = JobClassificationFacade.getJobClassificationService().find(jobClassificationComboId);

        final Job job = new Job.Builder(bean.getTitle())
                .code(bean.getCode())
                .description(bean.getDescription())
                .jobClassification(jobClassification)
                .positions(positions)
                .build();
        return job;
    }

    private Job getUpdateEntity(FieldGroup binder) {

        final JobBean bean = ((BeanItem<JobBean>) binder.getItemDataSource()).getBean();

        List<Position> positions = new ArrayList<>();
        for (String id : positionIds) {
            Position position = PositionFacade.getPositionService().find(id);
            positions.add(position);
        }

        JobClassification jobClassification = JobClassificationFacade.getJobClassificationService().find(jobClassificationComboId);

        final Job job = new Job.Builder(bean.getTitle())
                .code(bean.getCode())
                .description(bean.getDescription())
                .jobClassification(jobClassification)
                .positions(positions)
                .id(bean.getId())
                .build();
        return job;
    }

    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "JOB"));
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
        form.positionList.addValueChangeListener((ValueChangeListener) this);
        form.jobClassificationCombo.addValueChangeListener((ValueChangeListener) this);
    }
}
