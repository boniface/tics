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
import zm.hashcode.tics.app.facade.training.course.TargetGroupFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.funder.FunderMenu;
import zm.hashcode.tics.client.web.content.system.funder.forms.TargetGroupForm;
import zm.hashcode.tics.client.web.content.system.funder.model.TargetGroupBean;
import zm.hashcode.tics.client.web.content.system.funder.tables.TargetGroupTable;
import zm.hashcode.tics.client.web.content.system.funder.util.TargetGroupUtil;
import zm.hashcode.tics.domain.training.course.TargetGroup;

/**
 *
 * @author geek
 */
public class TargetGroupTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final TargetGroupForm form;
    private final TargetGroupTable table;

    public TargetGroupTab(TicsMain app) {
        main = app;
        form = new TargetGroupForm();
        table = new TargetGroupTable(main);
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
            final TargetGroup status = TargetGroupFacade.getTargetGroupService().find(table.getValue().toString());
            final TargetGroupBean bean = new TargetGroupUtil().getBean(status);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            TargetGroupFacade.getTargetGroupService().persist(getNewEntity(binder));
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
            TargetGroupFacade.getTargetGroupService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        TargetGroupFacade.getTargetGroupService().remove(getUpdateEntity(binder));
        getHome();
    }

    private TargetGroup getNewEntity(FieldGroup binder) {
        final TargetGroupBean bean = ((BeanItem<TargetGroupBean>) binder.getItemDataSource()).getBean();
        final TargetGroup targetGroup = new TargetGroup.Builder(bean.getName())
                .build();
        return targetGroup;
    }

    private TargetGroup getUpdateEntity(FieldGroup binder) {
        final TargetGroupBean bean = ((BeanItem<TargetGroupBean>) binder.getItemDataSource()).getBean();
        final TargetGroup targetGroup = new TargetGroup.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return targetGroup;
    }

    private void getHome() {
        main.content.setSecondComponent(new FunderMenu(main, "TARGETGROUP"));
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
