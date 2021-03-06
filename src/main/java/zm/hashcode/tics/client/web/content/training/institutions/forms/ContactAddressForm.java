/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.forms;

import com.google.common.collect.Collections2;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.content.training.institutions.model.ContactAddressBean;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.services.ui.location.predicates.CityPredicate;

/**
 *
 * @author geek
 */
public class ContactAddressForm extends FormLayout {

    private final ContactAddressBean bean;
    public final BeanItem<ContactAddressBean> item;
    public final FieldGroup binder;
    public ComboBox cityCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public ContactAddressForm() {
        bean = new ContactAddressBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField postalAddress = getTextField("Postal Address", "postalAddress");
        TextField physicalAddress = getTextField("Physical Address", "physicalAddress");
        TextField contactNumber = getTextField("Contact Number", "contactNumber");
        TextField postalCode = getTextField("Postal Code", "postalCode");
        TextField emailAddress = getTextField("Email", "emailAddres");
        ComboBox cityIdComboBox = getCityIdComboBox("City", "cityId");
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(postalAddress, 0, 0);
        grid.addComponent(physicalAddress, 1, 0);
        grid.addComponent(contactNumber, 2, 0);
        grid.addComponent(postalCode, 0, 1);
        grid.addComponent(emailAddress, 1, 1);
        grid.addComponent(cityIdComboBox, 2, 1);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private ComboBox getCityIdComboBox(String label, String field) {
        cityCombo.setCaption(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();
        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location city : cities) {
            cityCombo.addItem(city.getId());
            cityCombo.setItemCaption(city.getId(), city.getName());
        }
        cityCombo.addValidator(new BeanValidator(ContactAddressBean.class, field));
        cityCombo.setImmediate(true);
        cityCombo.setWidth(250, Unit.PIXELS);
        binder.bind(cityCombo, field);
        return cityCombo;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(ContactAddressBean.class, field));
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
