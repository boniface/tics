/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs;

import zm.hashcode.tics.client.web.content.system.facility.tabs.*;
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
import zm.hashcode.tics.app.facade.ui.demographics.LanguageProficiencyFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.PeopleMetaDataMenu;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.LanguageProficiencyForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.LanguageProficiencyBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.LanguageProficiencyTable;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.util.LanguageProficiencyUtil;
import zm.hashcode.tics.domain.ui.demographics.LanguageProficiency;

/**
 *
 * @author Ferox
 */
public final class LanguageProficiencyTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final LanguageProficiencyForm form;
    private final LanguageProficiencyTable table;

    public LanguageProficiencyTab(TicsMain app) {
        main = app;
        form = new LanguageProficiencyForm();
        table = new LanguageProficiencyTable(main);
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
            final LanguageProficiency languageProficiency = LanguageProficiencyFacade.getLanguageProficiencyService().find(table.getValue().toString());
            final LanguageProficiencyBean bean = new LanguageProficiencyUtil().getBean(languageProficiency);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LanguageProficiencyFacade.getLanguageProficiencyService().persist(getNewEntity(binder));
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
            LanguageProficiencyFacade.getLanguageProficiencyService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        LanguageProficiencyFacade.getLanguageProficiencyService().remove(getUpdateEntity(binder));
        getHome();
    }

    private LanguageProficiency getNewEntity(FieldGroup binder) {

        final LanguageProficiencyBean bean = ((BeanItem<LanguageProficiencyBean>) binder.getItemDataSource()).getBean();
        final LanguageProficiency languageProficiency = new LanguageProficiency.Builder(bean.getProficiency())
                .build();
        return languageProficiency;
    }

    private LanguageProficiency getUpdateEntity(FieldGroup binder) {

        final LanguageProficiencyBean bean = ((BeanItem<LanguageProficiencyBean>) binder.getItemDataSource()).getBean();
        final LanguageProficiency languageProficiency = new LanguageProficiency.Builder(bean.getProficiency())
                .id(bean.getId())
                .build();
        return languageProficiency;
    }

    private void getHome() {
        main.content.setSecondComponent(new PeopleMetaDataMenu(main, "PROFICIENCY"));
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
