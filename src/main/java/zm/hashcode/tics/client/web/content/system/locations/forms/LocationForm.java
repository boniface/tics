/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationBean;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author geek
 */
public class LocationForm extends FormLayout {

    private final LocationBean bean;
    public final BeanItem<LocationBean> item;
    public final FieldGroup binder;
    public ListSelect locationList = new ListSelect();
//    public ListSelect rolesList = new ListSelect();
//    // Define Buttons
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

//    private String id;
//    private String name;
//    private String code;
//    private String latitude;
//    private String longitude;
//    @DBRef
//    private LocationType locationType;
//    @DBRef
//    private List<Location> children;
//    @DBRef
//    private Location parent;

        TextField name = getTextField("Name", "name");
        TextField code = getTextField("Physical Address", "code");
        TextField latitude = getTextField("Latitude", "latitude");
        TextField longitude = getTextField("Longitude", "longitude");

        final ListSelect locations = getLocations("Select Location", "locationId");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(code, 1, 0);
        grid.addComponent(latitude, 2, 0);
        grid.addComponent(longitude, 0, 1);
        grid.addComponent(locations, 1, 1);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private ListSelect getLocations(String label, String field) {
        locationList.setCaption(label);
        locationList.setItemCaption(Long.valueOf("1"), "UNDER CONSTRUCTION");
//        List<Location> locations = LocationFacade.getLocationService().findAll();
//        for (Location iLocation : locations) {
//            locationList.setItemCaption(iLocation.getId(), iLocation.g() + " " + iLocation.getDescription());
//            locationList.setNullSelectionAllowed(false);
//            locationList.setMultiSelect(true);
//            locationList.addItem(iLocation.getId());
//        }
        locationList.setWidth("250px");
        binder.bind(locationList, field);

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
}
