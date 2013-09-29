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
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.offices.FacilityGroupingFacade;
import zm.hashcode.tics.app.facade.offices.FacilityTypeFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.facility.FacilityMenu;
import zm.hashcode.tics.client.web.content.system.facility.forms.FacilityForm;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityBean;
import zm.hashcode.tics.client.web.content.system.facility.tables.FacilityTable;
import zm.hashcode.tics.client.web.content.system.facility.util.FacilityUtil;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author Ferox
 */
public final class FacilityTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final FacilityForm form;
    private final FacilityTable table;

    public FacilityTab(TicsMain app) {
        main = app;
        form = new FacilityForm();
        table = new FacilityTable(main);
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
            final Facility facility = FacilityFacade.getFacilityService().find(table.getValue().toString());
            final FacilityBean bean = new FacilityUtil().getBean(facility);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            FacilityFacade.getFacilityService().persist(getNewEntity(binder));
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
            FacilityFacade.getFacilityService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        FacilityFacade.getFacilityService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Facility getNewEntity(FieldGroup binder) {
        final FacilityBean bean = ((BeanItem<FacilityBean>) binder.getItemDataSource()).getBean();



        FacilityType facilityType = FacilityTypeFacade.getFacilityTypeService().find(bean.getFacilityTypeId());
        Location city = LocationFacade.getLocationService().find(bean.getCityId());

        FacilityGrouping facilityGrouping = null;
        if (bean.getFacilityGroupingId() != null) {
            facilityGrouping = FacilityGroupingFacade.getFacilityGroupingService().find(bean.getFacilityGroupingId());
        }

        LocationAddress address = new LocationAddress.Builder(bean.getContactNumber())
                .emailAddress(bean.getEmailAddress())
                .physicalAddress(bean.getPhysicalAddress())
                .postalAddress(bean.getPostalAddress())
                .postalCode(bean.getPostalCode())
                .build();
        Facility facility = new Facility.Builder(bean.getFacilityName())
                .address(address)
                .latitude(bean.getLatitude())
                .longititude(bean.getLongititude())
                .city(city)
                .facilityGrouping(facilityGrouping)
                .facilityType(facilityType)
                .build();
        return facility;
    }

    private Facility getUpdateEntity(FieldGroup binder) {

        final FacilityBean bean = ((BeanItem<FacilityBean>) binder.getItemDataSource()).getBean();

        final Facility facility = FacilityFacade.getFacilityService().find(bean.getId());


        FacilityType facilityType = FacilityTypeFacade.getFacilityTypeService().find(bean.getFacilityTypeId());
        Location city = LocationFacade.getLocationService().find(bean.getCityId());

        FacilityGrouping facilityGrouping = null;
        if (bean.getFacilityGroupingId() != null) {
            facilityGrouping = FacilityGroupingFacade.getFacilityGroupingService().find(bean.getFacilityGroupingId());
        }

        LocationAddress address = new LocationAddress.Builder(bean.getContactNumber())
                .emailAddress(bean.getEmailAddress())
                .physicalAddress(bean.getPhysicalAddress())
                .postalAddress(bean.getPostalAddress())
                .postalCode(bean.getPostalCode())
                .build();
        Facility updateFacility = new Facility.Builder(bean.getFacilityName())
                .facility(facility)
                .latitude(bean.getLatitude())
                .longititude(bean.getLongititude())
                .address(address)
                .city(city)
                .facilityGrouping(facilityGrouping)
                .facilityType(facilityType)
                .build();
        return updateFacility;
    }

    private void getHome() {
        main.content.setSecondComponent(new FacilityMenu(main, "FACILITY"));
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
