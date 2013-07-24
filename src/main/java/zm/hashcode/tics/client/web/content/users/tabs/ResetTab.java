/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.tabs;

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
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.UserMenu;
import zm.hashcode.tics.client.web.content.users.forms.RoleForm;
import zm.hashcode.tics.client.web.content.users.tables.RoleTable;
import zm.hashcode.tics.domain.ui.demographics.Role;

/**
 *
 * @author Ferox
 */
public class ResetTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final RoleForm form;
    private final RoleTable table;

    public ResetTab(TicsMain app) {
        main = app;
        form = new RoleForm();
        table = new RoleTable(main);
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
            final Role role = UserFacade.getRoleService().find(table.getValue().toString());
            final Role bean = getBean(role);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            UserFacade.getRoleService().persist(getEntity(binder));
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
            UserFacade.getRoleService().merge(getEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        UserFacade.getRoleService().remove(getEntity(binder));
        getHome();
    }

    private Role getEntity(FieldGroup binder) {
        final Role bean = ((BeanItem<Role>) binder.getItemDataSource()).getBean();
        if (bean.getId() != null) {
            Role role = new Role.Builder(bean.getRolename())
                    .description(bean.getDescription())
                    .build();
            return role;
        } else {
            Role role = new Role.Builder(bean.getRolename())
                    .description(bean.getDescription())
                    .id(bean.getId())
                    .build();
            return role;
        }
    }

    private void getHome() {
        main.content.setSecondComponent(new UserMenu(main, "FUNDER"));
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

    private Role getBean(Role role) {
        Role bean = UserFacade.getRoleService().find(role.getId());
        return bean;
    }
}
