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
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.institutions.forms.ContactForm;
import zm.hashcode.tics.client.web.content.training.institutions.tables.ContactTable;

/**
 *
 * @author geek
 */
public class ContactTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ContactForm form;
    private final ContactTable table;
    private String cityId;

    public ContactTab(TicsMain app) {
        main = app;
        form = new ContactForm();
        table = new ContactTable(main);
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
//            final ContactList title = ContactListFacade.getContactListService().find(table.getValue().toString());
//            final ContactBean bean = new ContactUtil().getBean(title);
//            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.cityCombo) {
            cityId = property.getValue().toString();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
//            ContactListFacade.getContactListService().persist(getNewEntity(binder));
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
//            ContactListFacade.getContactListService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
//        ContactListFacade.getContactListService().remove(getUpdateEntity(binder));
        getHome();
    }

//    private Contact getNewEntity(FieldGroup binder) {
//        final ContactBean bean = ((BeanItem<ContactBean>) binder.getItemDataSource()).getBean();
//        final Contact contactList = new Contact.Builder(bean.getName())
//                .build();
//        return contactList;
//    }
//
//    private Contact getUpdateEntity(FieldGroup binder) {
//        final ContactBean bean = ((BeanItem<ContactBean>) binder.getItemDataSource()).getBean();
//        final Contact contactList = new Contact.Builder(bean.getName())
//                .id(bean.getId())
//                .build();
//        return contactList;
//    }
    private void getHome() {
        main.content.setSecondComponent(new InstitutionMenu(main, "CONTACTS"));
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
        form.cityCombo.addValueChangeListener((ValueChangeListener) this);
    }
}
