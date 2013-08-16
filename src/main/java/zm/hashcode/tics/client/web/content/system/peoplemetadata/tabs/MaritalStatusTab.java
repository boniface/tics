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
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.app.security.PasswordEncrypt;
import zm.hashcode.tics.app.security.PasswordGenerator;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.UserMenu;
import zm.hashcode.tics.client.web.content.users.forms.UserForm;
import zm.hashcode.tics.client.web.content.users.models.UserBean;
import zm.hashcode.tics.client.web.content.users.tables.UserTable;
import zm.hashcode.tics.client.web.content.users.util.UserUtil;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author Ferox
 */
public final class MaritalStatusTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final UserForm form;
    private final UserTable table;
    private Collection<String> rolesIds = new HashSet<>();
    private Collection<String> jusrisdicationIds = new HashSet<>();

    public MaritalStatusTab(TicsMain app) {
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
            final User user = UserFacade.getUserService().find(table.getValue().toString());
            final UserBean bean = new UserUtil().getBean(user);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        } else if (property == form.jurisdictionList) {
            jusrisdicationIds = (Collection<String>) property.getValue();
        } else if (property == form.rolesList) {
            rolesIds = (Collection<String>) property.getValue();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            UserFacade.getUserService().persist(getNewEntity(binder));
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
            UserFacade.getUserService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        UserFacade.getUserService().remove(getUpdateEntity(binder));
        getHome();
    }

    private User getNewEntity(FieldGroup binder) {
        String password = PasswordEncrypt.encrypt(new PasswordGenerator().getStaticPassword());
        final UserBean bean = ((BeanItem<UserBean>) binder.getItemDataSource()).getBean();
        Set<Role> roles = new HashSet<>();
        for (String id : rolesIds) {
            Role role = UserFacade.getRoleService().find(id);
            roles.add(role);
        }
        Set<Facility> facilities = new HashSet<>();
        for (String id : jusrisdicationIds) {
            Facility facility = FacilityFacade.getFacilityService().find(id);
            facilities.add(facility);
        }
        final User user = new User.Builder(bean.getEmail())
                .enable(bean.isEnabled())
                .firstname(bean.getFirstname())
                .lastname(bean.getLastname())
                .middlename(bean.getMiddlename())
                .passwd(password)
                .jusridication(facilities)
                .roles(roles)
                .build();
        return user;
    }

    private User getUpdateEntity(FieldGroup binder) {

        final UserBean bean = ((BeanItem<UserBean>) binder.getItemDataSource()).getBean();
        Set<Role> roles = new HashSet<>();
        for (String id : rolesIds) {
            Role role = UserFacade.getRoleService().find(id);
            roles.add(role);
        }
        Set<Facility> facilities = new HashSet<>();
        for (String id : jusrisdicationIds) {
            Facility facility = FacilityFacade.getFacilityService().find(id);
            facilities.add(facility);
        }
        final User user = new User.Builder(bean.getEmail())
                .enable(bean.isEnabled())
                .firstname(bean.getFirstname())
                .lastname(bean.getLastname())
                .middlename(bean.getMiddlename())
                .passwd(bean.getPasswd())
                .jusridication(facilities)
                .roles(roles)
                .id(bean.getId())
                .build();
        return user;
    }

    private void getHome() {
        main.content.setSecondComponent(new UserMenu(main, "LANDING"));
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
        form.jurisdictionList.addValueChangeListener((ValueChangeListener) this);
        form.rolesList.addValueChangeListener((ValueChangeListener) this);
    }

}
