/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs;

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
import java.util.HashSet;
import java.util.Set;
import zm.hashcode.tics.app.facade.ui.demographics.GenderFacade;
;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.PeopleMetaDataMenu;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.GenderForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.GenderBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.GenderTable;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.GenderForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.GenderBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.GenderTable;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.util.GenderUtil;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.PeopleMetaDataMenu;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.GenderForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.GenderBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.GenderTable;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.forms.GenderForm;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.GenderBean;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tables.GenderTable;
import zm.hashcode.tics.domain.ui.demographics.Gender;

/**
 *
 * @author Ferox
 */


public final class GenderTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final GenderForm form;
    private final GenderTable table;

    public GenderTab(TicsMain app) {
        main = app;
        form = new GenderForm();
        table = new GenderTable(main);
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
            final Gender gender = GenderFacade.getGenderService().find(table.getValue().toString());
            final GenderBean bean = new GenderUtil().getBean(gender);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            GenderFacade.getGenderService().persist(getNewEntity(binder));
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
            GenderFacade.getGenderService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        GenderFacade.getGenderService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Gender getNewEntity(FieldGroup binder) {
        final GenderBean bean = ((BeanItem<GenderBean>) binder.getItemDataSource()).getBean();
        final Gender gender = new Gender.Builder(bean.getGender())
                .build();
        return gender;
    }

    private Gender getUpdateEntity(FieldGroup binder) {

        final GenderBean bean = ((BeanItem<GenderBean>) binder.getItemDataSource()).getBean();
        final Gender gender = new Gender.Builder(bean.getGender())
                .id(bean.getId())
                .build();
        return gender;
    }

    private void getHome() {
        main.content.setSecondComponent(new PeopleMetaDataMenu(main, "LANDING"));
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
