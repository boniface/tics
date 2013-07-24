/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import zm.hashcode.tics.client.web.content.users.models.UserBean;

/**
 *
 * @author boniface
 */
public class UserForm extends FormLayout {

    private final UserBean bean;
    public final BeanItem<UserBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public UserForm() {
        bean = new UserBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        
//            private String id;
//    private String email;
//    private String passwd;
//    private String firstname;
//    private String lastname;
//    private String middlename;
//    private boolean enabled;

        TextField firstname = getTextField("First Name", "firstname");
        TextField lastname = getTextField("Last Name", "lastname");
        TextField middlename = getTextField("Middle Name", "middlename");
        TextField email = getTextField("Email", "email");
       
//        TextArea postalAddress = getTextArea("Postal Address", "postalAddress");
//        TextArea physicalAddress = getTextArea("Physical  Address", "physicalAddress");
//        ComboBox city = getComboBox("City", "city");


        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();
        
        grid.addComponent(firstname, 0, 0);
        grid.addComponent(middlename, 1, 0);
        grid.addComponent(lastname, 2, 0);
        grid.addComponent(email, 3, 0);
   
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
    }

    private TextArea getTextArea(String label, String field) {
        TextArea textArea = new TextArea(label);
        textArea.setWidth(250, Unit.PIXELS);
        textArea.setNullRepresentation("");
        textArea.addValidator(new BeanValidator(UserBean.class, field));
        textArea.setImmediate(true);
        binder.bind(textArea, field);
        return textArea;

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(UserBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
//        List<Location> locations = LocationFacade.getLocationModelService().findAll();
//        
////        List<Location> sortedCopy = Ordering.from(byLastName).compound(byFirstName).reverse().sortedCopy(locations);
////        List<Location> sortedList = Ordering.natural().reverse().sortedCopy(this);
//        
//        Collection<Location> cities = Collections2.filter(locations, new CityPredicate());
//        for (Location location : cities) {
//            comboBox.addItem(location.getId());
//            comboBox.setItemCaption(location.getId(), location.getName());
//        }
//        comboBox.addValidator(new BeanValidator(UserBean.class, field));
//        comboBox.setImmediate(true);
//        comboBox.setWidth(250, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
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
