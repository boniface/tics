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
import com.vaadin.ui.TextField;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationAddressBean;

/**
 *
 * @author geek
 */
public class LocationAddressForm extends FormLayout {

    private final LocationAddressBean bean;
    public final BeanItem<LocationAddressBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public LocationAddressForm() {
        bean = new LocationAddressBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//    private String postalAddress;
//    private String physicalAddress;
//    private String contactNumber;
//    private String postalCode;
//    private String emailAddress;

        TextField postalAddress = getTextField("Postal Address", "postalAddress");
        TextField physicalAddress = getTextField("Physical Address", "physicalAddress");
        TextField contactNumber = getTextField("Contact Number", "contactNumber");
        TextField postalCode = getTextField("Postal Code", "postalCode");
        TextField emailAddress = getTextField("Email Address", "emailAddress");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(postalAddress, 0, 0);
        grid.addComponent(physicalAddress, 1, 0);
        grid.addComponent(contactNumber, 2, 0);
        grid.addComponent(postalCode, 0, 1);
        grid.addComponent(emailAddress, 1, 1);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(LocationAddressBean.class, field));
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
