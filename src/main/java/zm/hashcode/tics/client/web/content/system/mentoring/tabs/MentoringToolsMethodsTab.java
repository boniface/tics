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
import zm.hashcode.tics.app.facade.training.mentoring.MentoringToolsMethodsFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.mentoring.MentoringSetupMenu;
import zm.hashcode.tics.client.web.content.system.mentoring.forms.MentoringToolsMethodsForm;
import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringToolsMethodsBean;
import zm.hashcode.tics.client.web.content.system.mentoring.tables.MentoringToolsMethodsTable;
import zm.hashcode.tics.client.web.content.system.mentoring.util.MentoringToolsMethodsUtil;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;

/**
 *
 * @author Ferox
 */
public final class MentoringToolsMethodsTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final MentoringToolsMethodsForm form;
    private final MentoringToolsMethodsTable table;

    public MentoringToolsMethodsTab(TicsMain app) {
        main = app;
        form = new MentoringToolsMethodsForm();
        table = new MentoringToolsMethodsTable(main);
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
            final MentoringToolsMethods mentoringToolsMethods = MentoringToolsMethodsFacade.getMentoringToolsMethodsService().find(table.getValue().toString());
            final MentoringToolsMethodsBean bean = new MentoringToolsMethodsUtil().getBean(mentoringToolsMethods);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            MentoringToolsMethodsFacade.getMentoringToolsMethodsService().persist(getNewEntity(binder));
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
            MentoringToolsMethodsFacade.getMentoringToolsMethodsService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        MentoringToolsMethodsFacade.getMentoringToolsMethodsService().remove(getUpdateEntity(binder));
        getHome();
    }

    private MentoringToolsMethods getNewEntity(FieldGroup binder) {
        final MentoringToolsMethodsBean bean = ((BeanItem<MentoringToolsMethodsBean>) binder.getItemDataSource()).getBean();
        final MentoringToolsMethods mentoringToolsMethods = new MentoringToolsMethods.Builder(bean.getToolsMethod())
                .build();
        return mentoringToolsMethods;
    }

    private MentoringToolsMethods getUpdateEntity(FieldGroup binder) {
        final MentoringToolsMethodsBean bean = ((BeanItem<MentoringToolsMethodsBean>) binder.getItemDataSource()).getBean();
        final MentoringToolsMethods mentoringToolsMethods = new MentoringToolsMethods.Builder(bean.getToolsMethod())
                .id(bean.getId())
                .build();
        return mentoringToolsMethods;
    }

    private void getHome() {
        main.content.setSecondComponent(new MentoringSetupMenu(main, "TOOLS"));
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
