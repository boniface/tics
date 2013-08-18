/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.tabs;

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
import zm.hashcode.tics.app.facade.ui.location.ContactListFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.locations.LocationsMenu;
import zm.hashcode.tics.client.web.content.system.locations.forms.ContactListForm;
import zm.hashcode.tics.client.web.content.system.locations.model.ContactListBean;
import zm.hashcode.tics.client.web.content.system.locations.tables.ContactListTable;
import zm.hashcode.tics.client.web.content.system.locations.util.ContactListUtil;
import zm.hashcode.tics.domain.ui.location.ContactList;

/**
 *
 * @author geek
 */
public class ContactListTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ContactListForm form;
    private final ContactListTable table;

    public ContactListTab(TicsMain app) {
        main = app;
        form = new ContactListForm();
        table = new ContactListTable(main);
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
            final ContactList title = ContactListFacade.getContactListService().find(table.getValue().toString());
            final ContactListBean bean = new ContactListUtil().getBean(title);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            ContactListFacade.getContactListService().persist(getNewEntity(binder));
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
            ContactListFacade.getContactListService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        ContactListFacade.getContactListService().remove(getUpdateEntity(binder));
        getHome();
    }

    private ContactList getNewEntity(FieldGroup binder) {
        final ContactListBean bean = ((BeanItem<ContactListBean>) binder.getItemDataSource()).getBean();
        final ContactList contactList = new ContactList.Builder(bean.getName())
                .build();
        return contactList;
    }

    private ContactList getUpdateEntity(FieldGroup binder) {
        final ContactListBean bean = ((BeanItem<ContactListBean>) binder.getItemDataSource()).getBean();
        final ContactList contactList = new ContactList.Builder(bean.getName())
                .id(bean.getId())
                .build();
        return contactList;
    }

    private void getHome() {
        main.content.setSecondComponent(new LocationsMenu(main, "CONTACTLIST"));
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
