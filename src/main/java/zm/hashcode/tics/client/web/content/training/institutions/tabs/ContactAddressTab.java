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
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.institutions.InstitutionMenu;
import zm.hashcode.tics.client.web.content.training.institutions.forms.ContactAddressForm;
import zm.hashcode.tics.client.web.content.training.institutions.model.ContactAddressBean;
import zm.hashcode.tics.client.web.content.training.institutions.tables.ContactAddressTable;
import zm.hashcode.tics.client.web.content.training.institutions.util.TrainingInstructorUtil;
import zm.hashcode.tics.domain.training.institutions.InstitutionAddress;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author geek
 */
public class ContactAddressTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ContactAddressForm form;
    private final ContactAddressTable table;

    public ContactAddressTab(TicsMain app) {
        main = app;
        form = new ContactAddressForm();
        table = new ContactAddressTable(main);
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
//            final ContactAddressBean title = ContactListFacade.getContactListService().find(table.getValue().toString());
//            final ContactAddressBean bean = new ContactUtil().getBean(title);
//            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            InstitutionAddress address = getNewEntity(binder);
            List<InstitutionAddress> addresses = new ArrayList<>();
            TrainingInstitution trainingInstitution = TrainingInstructorUtil.getTrainingInstitution();
            addresses.add(address);
            addresses.addAll(trainingInstitution.getInstitutionAddresses());
            TrainingInstitution updatedTrainingInstitution = new TrainingInstitution.Builder(trainingInstitution.getName())
                    .trainingInstitution(trainingInstitution)
                    .institutionAddresses(addresses)
                    .build();
            TrainingInstitutionFacade.getTrainingInstitutionService().merge(updatedTrainingInstitution);
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

    private InstitutionAddress getNewEntity(FieldGroup binder) {
        final ContactAddressBean bean = ((BeanItem<ContactAddressBean>) binder.getItemDataSource()).getBean();
        final Location city = LocationFacade.getLocationService().find(bean.getCityId());
        final LocationAddress locationAddress = new LocationAddress.Builder(bean.getContactNumber())
                .emailAddress(bean.getEmailAddres())
                .physicalAddress(bean.getPhysicalAddress())
                .postalAddress(bean.getPostalAddress())
                .postalCode(bean.getPostalCode())
                .build();
        final InstitutionAddress institutionAddress = new InstitutionAddress.Builder(locationAddress)
                .city(city)
                .build();
        return institutionAddress;
    }
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
