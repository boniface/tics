/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.forms;

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
import zm.hashcode.tics.app.facade.ui.location.LocationFacade;
import zm.hashcode.tics.client.web.content.system.funder.model.FunderBean;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author geek
 */
public class FunderForm extends FormLayout {

    private final FunderBean bean;
    public final BeanItem<FunderBean> item;
    public final FieldGroup binder;
    public ComboBox locationComboBox = new ComboBox();
//    public ListSelect locationList = new ListSelect();
//    public ListSelect rolesList = new ListSelect();
    //
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
//

    public FunderForm() {
        bean = new FunderBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//    private String id;
//    private String trainingFunderName;
//    private String courseCenter;
//    @DBRef
//    private Location city;
//    private LocationAddress contact;
        // blow out LocationAddress ATTRIBUTE below
//          private String postalAddress;
//          private String physicalAddress;
//          private String contactNumber;
//          private String postalCode;
//          private String emailAddress;

        TextField trainingFunderName = getTextField("Training Funder Name", "trainingFunderName");
        TextField courseCenter = getTextField("Cost Center", "courseCenter");
        ComboBox locationCombo = getLocationComboBox("City", "locationId");
        TextField postalAddress = getTextField("Postal Address", "postalAddress");
        TextField physicalAddress = getTextField("Physical Address", "physicalAddress");
        TextField contactNumber = getTextField("Contact Number", "contactNumber");
        TextField postalCode = getTextField("Postal Code", "postalCode");
        TextField emailAddress = getTextField("Email Address", "emailAddress");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(trainingFunderName, 0, 0);
        grid.addComponent(courseCenter, 1, 0);
        grid.addComponent(locationCombo, 2, 0);
        grid.addComponent(postalAddress, 3, 0);
        grid.addComponent(physicalAddress, 0, 1);

        grid.addComponent(contactNumber, 1, 1);
        grid.addComponent(postalCode, 2, 1);
        grid.addComponent(emailAddress, 3, 1);

        grid.addComponent(buttons, 0, 2, 2, 2); // 0, 3, 2, 3

        addComponent(grid);
    }

    private ComboBox getLocationComboBox(String label, String field) {
//        ComboBox comboBox = new ComboBox(label);
        locationComboBox.setCaption(label);
        List<Location> locations = LocationFacade.getLocationService().findAll();

//        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
//        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);

//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
        for (Location iLocation : locations) {
            locationComboBox.addItem(iLocation.getId());
            locationComboBox.setItemCaption(iLocation.getId(), iLocation.getName());
        }
        locationComboBox.addValidator(new BeanValidator(FunderBean.class, field));
        locationComboBox.setImmediate(true);
        locationComboBox.setWidth(250, Unit.PIXELS);
        binder.bind(locationComboBox, field);
        return locationComboBox;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(FunderBean.class, field));
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
