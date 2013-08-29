/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.app.facade.ui.location.LocationTypeFacade;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationBean;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationForm extends FormLayout {

    private final LocationBean bean;
    public final BeanItem<LocationBean> item;
    public final FieldGroup binder;
    public ListSelect locationList = new ListSelect();
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
//

    public LocationForm() {
        bean = new LocationBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        final ComboBox locationTypeId = getLocationTypeComboBox("Location Type", "locationTypeId");
        final TextField name = getTextField("Location Name", "name");
        final TextField code = getTextField("Location Code", "code");

        TextField latitude = getTextField("Latitude", "latitude");
        TextField longitude = getTextField("Longitude", "longitude");
        final ComboBox parentId = getLocationParentComboBox("Parent Location", "parentId");


        final ListSelect childrenIds = getLocations("Select Child Location", "childrenIds");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(locationTypeId, 0, 0);
        grid.addComponent(name, 1, 0);
        grid.addComponent(code, 2, 0);

        grid.addComponent(longitude, 0, 1);
        grid.addComponent(latitude, 1, 1);
        grid.addComponent(parentId, 2, 1);
        grid.addComponent(childrenIds, 0, 2);


        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private ComboBox getLocationParentComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
        for (Location location : locations) {
            comboBox.addItem(location.getId());
            comboBox.setItemCaption(location.getId(), location.getName());
        }
        comboBox.addValidator(new BeanValidator(LocationBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ComboBox getLocationTypeComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<LocationType> locationTypes = LocationTypeFacade.getLocationTypeService().findAll();
        for (LocationType locationType : locationTypes) {
            comboBox.addItem(locationType.getId());
            comboBox.setItemCaption(locationType.getId(), locationType.getName());
        }
        comboBox.addValidator(new BeanValidator(LocationBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }

    private ListSelect getLocations(String label, String field) {
        locationList.setCaption(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
        for (Location location : locations) {
            locationList.setItemCaption(location.getId(), location.getName() + " " + getLocationType(location.getLocationType()));
            locationList.setNullSelectionAllowed(false);
            locationList.setMultiSelect(true);
            locationList.addItem(location.getId());
        }
        return locationList;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(LocationBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        return buttons;
    }

    private String getLocationType(LocationType locationType) {
        if (locationType != null) {
            return locationType.getName();
        }
        return null;
    }
}
