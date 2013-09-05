/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tabs;

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
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFieldFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.mentoring.MentoringSetupMenu;
import zm.hashcode.tics.client.web.content.system.mentoring.forms.MentoringFieldForm;
import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringFieldBean;
import zm.hashcode.tics.client.web.content.system.mentoring.tables.MentoringFieldTable;
import zm.hashcode.tics.client.web.content.system.mentoring.util.MentoringFieldUtil;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;

/**
 *
 * @author geek
 */
public class MentoringFieldTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final MentoringFieldForm form;
    private final MentoringFieldTable table;

    public MentoringFieldTab(TicsMain app) {
        main = app;
        form = new MentoringFieldForm();
        table = new MentoringFieldTable(main);
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
            final MentoringField mentoringObjective = MentoringFieldFacade.getMentoringFieldService().find(table.getValue().toString());
            final MentoringFieldBean bean = new MentoringFieldUtil().getBean(mentoringObjective);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringFieldFacade.getMentoringFieldService().persist(getNewEntity(binder));
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
            MentoringFieldFacade.getMentoringFieldService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        MentoringFieldFacade.getMentoringFieldService().remove(getUpdateEntity(binder));
        getHome();
    }

    private MentoringField getNewEntity(FieldGroup binder) {
        final MentoringFieldBean bean = ((BeanItem< MentoringFieldBean>) binder.getItemDataSource()).getBean();
        final MentoringField MentoringField = new MentoringField.Builder(bean.getFieldName())
                .build();
        return MentoringField;
    }

    private MentoringField getUpdateEntity(FieldGroup binder) {
        final MentoringFieldBean bean = ((BeanItem< MentoringFieldBean>) binder.getItemDataSource()).getBean();
        final MentoringField MentoringField = new MentoringField.Builder(bean.getFieldName())
                .id(bean.getId())
                .build();
        return MentoringField;
    }

    private void getHome() {
        main.content.setSecondComponent(new MentoringSetupMenu(main, "FIELD"));
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

    }
}
