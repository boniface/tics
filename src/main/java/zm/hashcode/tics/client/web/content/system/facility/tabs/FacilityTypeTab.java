/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tabs;

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
import zm.hashcode.tics.app.facade.offices.FacilityTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.facility.FacilityMenu;
import zm.hashcode.tics.client.web.content.system.facility.forms.FacilityTypeForm;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityTypeBean;
import zm.hashcode.tics.client.web.content.system.facility.tables.FacilityTypeTable;
import zm.hashcode.tics.client.web.content.system.facility.util.FacilityUtil;
import zm.hashcode.tics.domain.offices.FacilityType;

/**
 *
 * @author ColinWa
 */
public final class FacilityTypeTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final FacilityTypeForm form;
    private final FacilityTypeTable table;

    public FacilityTypeTab(TicsMain app) {
        main = app;
        form = new FacilityTypeForm();
        table = new FacilityTypeTable(main);
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
            final FacilityType facilityType = FacilityTypeFacade.getFacilityTypeService().find(table.getValue().toString());
            final FacilityTypeBean bean = new FacilityUtil().getBean(facilityType);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }

    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            FacilityTypeFacade.getFacilityTypeService().persist(getNewEntity(binder));
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
            FacilityTypeFacade.getFacilityTypeService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        FacilityTypeFacade.getFacilityTypeService().remove(getUpdateEntity(binder));
        getHome();
    }

    private FacilityType getNewEntity(FieldGroup binder) {

        final FacilityTypeBean bean = ((BeanItem<FacilityTypeBean>) binder.getItemDataSource()).getBean();

        final FacilityType facilityType = new FacilityType.Builder(bean.getFacilityName())
                .build();
        return facilityType;
    }

    private FacilityType getUpdateEntity(FieldGroup binder) {
        final FacilityTypeBean bean = ((BeanItem<FacilityTypeBean>) binder.getItemDataSource()).getBean();
        final FacilityType facilityType = new FacilityType.Builder(bean.getFacilityName())
                .id(bean.getId())
                .build();
        return facilityType;
    }

    private void getHome() {
        main.content.setSecondComponent(new FacilityMenu(main, "FACILITYTYPE"));
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
