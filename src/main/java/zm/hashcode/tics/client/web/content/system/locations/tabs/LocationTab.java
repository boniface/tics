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
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.locations.LocationsMenu;
import zm.hashcode.tics.client.web.content.system.locations.forms.LocationForm;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationBean;
import zm.hashcode.tics.client.web.content.system.locations.tables.LocationTable;
import zm.hashcode.tics.client.web.content.system.locations.util.LocationUtil;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationTab extends VerticalLayout implements
        Button.ClickListener, Property.ValueChangeListener {

    private final TicsMain main;
    private final LocationForm form;
    private final LocationTable table;

    public LocationTab(TicsMain app) {
        main = app;
        form = new LocationForm();
        table = new LocationTable(main);
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
            final Location location = LocationFacade.getLocationService().find(table.getValue().toString());
            final LocationBean bean = new LocationUtil().getBean(location);
            form.binder.setItemDataSource(new BeanItem<>(bean));
            setReadFormProperties();
        }
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            LocationFacade.getLocationService().persist(getNewEntity(binder));
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
            LocationFacade.getLocationService().merge(getUpdateEntity(binder));
            getHome();
            Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }
    }

    private void deleteForm(FieldGroup binder) {
        LocationFacade.getLocationService().remove(getUpdateEntity(binder));
        getHome();
    }

    private Location getNewEntity(FieldGroup binder) {
        final LocationBean bean = ((BeanItem<LocationBean>) binder.getItemDataSource()).getBean();
//        LocationType locationTyp = LocationTypeFacade.getLocationTypeService().find(bean.g)
        final Location location = new Location.Builder(bean.getName())
                .children(bean.getChildren())
                .code(bean.getCode())
                .latitude(bean.getLatitude())
                //                .locationType(bean.getLocationType())
                .longitude(bean.getLongitude())
                //                .parent(bean.getParent())

                .build();
        return location;
    }

    private Location getUpdateEntity(FieldGroup binder) {
        final LocationBean bean = ((BeanItem<LocationBean>) binder.getItemDataSource()).getBean();
//        LocationType locationTyp = LocationTypeFacade.getLocationTypeService().find(bean.g)
        final Location location = new Location.Builder(bean.getName())
                .children(bean.getChildren())
                .code(bean.getCode())
                .latitude(bean.getLatitude())
                //                .locationType(bean.getLocationType())
                .longitude(bean.getLongitude())
                //                .parent(bean.getParent())
                .id(bean.getId())
                .build();
        return location;
    }

    private void getHome() {
        main.content.setSecondComponent(new LocationsMenu(main, "LOCATION"));
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
