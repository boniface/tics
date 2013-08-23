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
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationTypeFacade;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationTypeBean;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationTypeForm extends FormLayout {

    private final LocationTypeBean bean;
    public final BeanItem<LocationTypeBean> item;
    public final FieldGroup binder;
    public ComboBox locationTypeParentIdCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public LocationTypeForm() {
        bean = new LocationTypeBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//           private String id;
//    @NotNull
//    private String name;
//    @NotNull
//    private String code;
//        private String locationTypeParentId;

        TextField name = getTextField("Location Type Name", "name");
        TextField code = getTextField("Code", "code");
        final ComboBox locationTypeParentIdComboBox = getlocationTypeParentIdComboBox("Location Parent Type", "locationTypeParentId");
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(code, 0, 1);
        grid.addComponent(locationTypeParentIdComboBox, 1, 0);
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(LocationTypeBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getlocationTypeParentIdComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        locationTypeParentIdCombo.setCaption(label);
        List<LocationType> locationTypes = LocationTypeFacade.getLocationTypeService().findAll();
        for (LocationType iLocationType : locationTypes) {
            locationTypeParentIdCombo.addItem(iLocationType.getId());
            locationTypeParentIdCombo.setItemCaption(iLocationType.getId(), iLocationType.getName() + " - " + iLocationType.getCode());
        }
        locationTypeParentIdCombo.addValidator(new BeanValidator(LocationTypeBean.class, field));
        locationTypeParentIdCombo.setImmediate(true);
        locationTypeParentIdCombo.setWidth(250, Unit.PIXELS);
        binder.bind(locationTypeParentIdCombo, field);
        return locationTypeParentIdCombo;
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
