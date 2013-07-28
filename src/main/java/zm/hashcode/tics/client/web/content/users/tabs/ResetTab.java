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
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.users.UserMenu;
import zm.hashcode.tics.client.web.content.users.forms.ResetForm;

/**
 *
 * @author Ferox
 */
public class ResetTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final ResetForm form;

    public ResetTab(TicsMain app) {
        main = app;
        form = new ResetForm();

        setSizeFull();
        addComponent(form);

        addListeners();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == form.reset) {
            resetPassword(form.binder);
        } else if (source == form.cancel) {
            getHome();
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        final Property property = event.getProperty();
        if (property == form.comboBoxUsers) {
            

            setReadFormProperties();
        }
    }

    private void resetPassword(FieldGroup binder) {
        try {
            binder.commit();
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }


    private void deleteForm(FieldGroup binder) {

        getHome();
    }

    private void getHome() {
        main.content.setSecondComponent(new UserMenu(main, "RESETS"));
    }

    private void setEditFormProperties() {
        form.binder.setReadOnly(false);
        form.reset.setVisible(false);
        form.cancel.setVisible(true);

    }

    private void setReadFormProperties() {
        form.binder.setReadOnly(true);
        //Buttons Behaviou
        form.reset.setVisible(true);
        form.cancel.setVisible(true);

    }

    private void addListeners() {
        //Register Button Listeners
        form.reset.addClickListener((ClickListener) this);
        form.cancel.addClickListener((ClickListener) this);

        //Register Table Listerners
        form.comboBoxUsers.addValueChangeListener((ValueChangeListener) this);
    }
}
