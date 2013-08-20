/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.tabs;

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
import zm.hashcode.tics.app.facade.ui.position.DepartureReasonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.positions.PositionsMenu;
import zm.hashcode.tics.client.web.content.system.positions.forms.DepartureReasonForm;
import zm.hashcode.tics.client.web.content.system.positions.model.DepartureReasonBean;
import zm.hashcode.tics.client.web.content.system.positions.tables.DepartureReasonTable;
import zm.hashcode.tics.client.web.content.system.positions.util.DepartureReasonUtil;
import zm.hashcode.tics.domain.ui.position.DepartureReason;

/**
 *
 * @author Ferox
 */
public final class ReasonsForDepartureTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final DepartureReasonForm form;
    private final DepartureReasonTable table;
    private Collection<String> rolesIds = new HashSet<>();
    private Collection<String> jusrisdicationIds = new HashSet<>();

    public ReasonsForDepartureTab(TicsMain app) {
        main = app;
        form = new DepartureReasonForm();
        table = new DepartureReasonTable(main);
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
            final DepartureReason user = DepartureReasonFacade.getDepartureReasonService().find(table.getValue().toString());
            final DepartureReasonBean bean = new DepartureReasonUtil().getBean(user);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            DepartureReasonFacade.getDepartureReasonService().persist(getNewEntity(binder));
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
            DepartureReasonFacade.getDepartureReasonService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        DepartureReasonFacade.getDepartureReasonService().remove(getUpdateEntity(binder));
        getHome();
    }

    private DepartureReason getNewEntity(FieldGroup binder) {
        final DepartureReasonBean bean = ((BeanItem<DepartureReasonBean>) binder.getItemDataSource()).getBean();

        final DepartureReason departureReason = new DepartureReason.Builder(bean.getReasonName())
                .description(bean.getDescription())
                .build();
        return departureReason;
    }

    private DepartureReason getUpdateEntity(FieldGroup binder) {

        final DepartureReasonBean bean = ((BeanItem<DepartureReasonBean>) binder.getItemDataSource()).getBean();

        final DepartureReason departureReason = new DepartureReason.Builder(bean.getReasonName())
                .description(bean.getDescription())
                .id(bean.getId())
                .build();
        return departureReason;
    }

    private void getHome() {
        main.content.setSecondComponent(new PositionsMenu(main, "DEPARTURE"));
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
