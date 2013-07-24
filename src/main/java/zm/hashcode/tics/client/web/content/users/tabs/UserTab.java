/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.tabs;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.forms.UserForm;
import zm.hashcode.tics.client.web.content.users.models.UserBean;
import zm.hashcode.tics.client.web.content.users.tables.UserTable;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author Ferox
 */
public class UserTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final UserForm form;
    private final UserTable table;

    public UserTab(TicsMain app) {
        main = app;
        form = new UserForm();
        table = new UserTable(main);
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
//            final User funder = UtilFacade.getUserModelService().findById(table.getValue().toString());
//            final UserBean bean = getBean(funder);
//            form.binder.setItemDataSource(new BeanItem<UserBean>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
//        try {
//            binder.commit();
//            UtilFacade.getUserModelService().persist(getEntity(binder));
//            getHome();
//            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
//        } catch (FieldGroup.CommitException e) {
//            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
//            getHome();
//        }
    }

    private void saveEditedForm(FieldGroup binder) {
//        try {
//            binder.commit();
//            UtilFacade.getUserModelService().merge(getEntity(binder));
//            getHome();
//            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
//        } catch (FieldGroup.CommitException e) {
//            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
//            getHome();
//        }
    }

    private void deleteForm(FieldGroup binder) {
//        UtilFacade.getUserModelService().removeById(getEntity(binder).getId());
        getHome();
    }

    private User getEntity(FieldGroup binder) {
//        final UserBean funderBean = ((BeanItem<UserBean>) binder.getItemDataSource()).getBean();
//        final Location city = LocationFacade.getLocationModelService().findById(funderBean.getCity());
//        final LocationAddress address = new OfficeFactory.LocationAddressBuilder(funderBean.getPostalAddress())
//                .contactNumber(funderBean.getContactNumber())
//                .physicalAddress(funderBean.getPhysicalAddress())
//                .postalCode(funderBean.getPostalCode())
//                .build();
//        final User funder = new UtilFactory.UserBuilder(funderBean.getTrainingUserName())
//                .costCenter(funderBean.getCostCenter())
//                .city(city)
//                .contact(address)
//                .build();
//        funder.setId(funderBean.getId());
//        
        return null;

    }

    private void getHome() {
//        main.content.setSecondComponent(new UtilitiesMenu(main, "FUNDER"));
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

    private UserBean getBean(User funder) {
//        UserBean bean = new UserBean();
//        bean.setCity(funder.getCity().getId());
//        bean.setContactNumber(funder.getContact().getContactNumber());
//        bean.setCostCenter(funder.getCostCenter());
//        bean.setId(funder.getId());
//        bean.setPhysicalAddress(funder.getContact().getPhysicalAddress());
//        bean.setPostalAddress(funder.getContact().getPostalAddress());
//        bean.setPostalCode(funder.getContact().getPostalCode());
//        bean.setTrainingUserName(funder.getTrainingUserName());
        return null;
    }
}
