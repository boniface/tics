/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.tabs;

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
import zm.hashcode.tics.app.facade.ui.util.StatusFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.funder.FunderMenu;
import zm.hashcode.tics.client.web.content.system.funder.forms.StatusForm;
import zm.hashcode.tics.client.web.content.system.funder.model.StatusBean;
import zm.hashcode.tics.client.web.content.system.funder.tables.StatusTable;
import zm.hashcode.tics.client.web.content.system.funder.util.StatusUtil;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class StatusTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final StatusForm form;
    private final StatusTable table;

    public StatusTab(TicsMain app) {
        main = app;
        form = new StatusForm();
        table = new StatusTable(main);
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
            final Status status = StatusFacade.getStatusService().find(table.getValue().toString());
            final StatusBean bean = new StatusUtil().getBean(status);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            StatusFacade.getStatusService().persist(getNewEntity(binder));
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
            StatusFacade.getStatusService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        StatusFacade.getStatusService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Status getNewEntity(FieldGroup binder) {
        final StatusBean bean = ((BeanItem<StatusBean>) binder.getItemDataSource()).getBean();
        final Status status = new Status.Builder(bean.getStatusType())
                .statusValue(bean.getStatusValue())
                .build();
        return status;
    }

    private Status getUpdateEntity(FieldGroup binder) {
        final StatusBean bean = ((BeanItem<StatusBean>) binder.getItemDataSource()).getBean();
        final Status status = new Status.Builder(bean.getStatusType())
                .statusValue(bean.getStatusValue())
                .id(bean.getId())
                .build();
        return status;
    }

    private void getHome() {
        main.content.setSecondComponent(new FunderMenu(main, "STATUS"));
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
