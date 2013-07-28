/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.users.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.user.UserFacade;

import zm.hashcode.tics.client.web.content.users.models.UserBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.ui.demographics.Role;

/**
 *
 * @author boniface
 */
public final class UserForm extends FormLayout {

    private final UserBean bean;
    public final BeanItem<UserBean> item;
    public final FieldGroup binder;
    public ListSelect jurisdictionList = new ListSelect();
    public ListSelect rolesList = new ListSelect();
    // Define Buttons
    public final Button save = new Button("Save");
    public final Button edit = new Button("Edit");
    public final Button cancel = new Button("Cancel");
    public final Button update = new Button("Update");
    public final Button delete = new Button("Delete");

    public UserForm() {
        bean = new UserBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        final HorizontalLayout buttons = getButtons();
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

//            private List<String> roles;
//    private List<String> jusridication;

        final TextField firstname = getTextField("First Name", "firstname");
        final TextField lastname = getTextField("Last Name", "lastname");
        final TextField middlename = getTextField("Middle Name", "middlename");

        final TextField email = getTextField("Email Address", "email");
        final CheckBox enable = getCheckBoxField("Activate Account", "enabled");
        final ListSelect roles = getRoles("Select Roles", "roleIds");
        final ListSelect jurisdictions = getJurisdication("Select Facility In Charge Of", "jusridicationIds");

//        TextArea postalAddress = getTextArea("Postal Address", "postalAddress");
//        TextArea physicalAddress = getTextArea("Physical  Address", "physicalAddress");
//        ComboBox city = getComboBox("City", "city");


        final GridLayout grid = new GridLayout(3, 10);
        grid.setSizeFull();

        grid.addComponent(firstname, 0, 0);
        grid.addComponent(middlename, 1, 0);
        grid.addComponent(lastname, 2, 0);

        grid.addComponent(email, 0, 1);
        grid.addComponent(enable, 0, 2);

        grid.addComponent(roles, 1, 1, 1, 2);

        grid.addComponent(jurisdictions, 2, 1, 2, 2);

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

    private CheckBox getCheckBoxField(String label, String field) {
        CheckBox checkBox = new CheckBox(label);
        checkBox.setWidth(250, Unit.PIXELS);
        checkBox.addValidator(new BeanValidator(UserBean.class, field));
        checkBox.setImmediate(true);
        binder.bind(checkBox, field);
        return checkBox;
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

    private ListSelect getRoles(String label, String field) {
        rolesList.setCaption(label);
        List<Role> roles = UserFacade.getRoleService().findAll();
        for (Role role : roles) {
            rolesList.setItemCaption(role.getId(), role.getRolename() + " " + role.getDescription());
            rolesList.setNullSelectionAllowed(false);
            rolesList.setMultiSelect(true);
            rolesList.addItem(role.getId());
        }
        rolesList.setWidth("250px");
        binder.bind(rolesList, field);
        
        return rolesList;
    }

    private ListSelect getJurisdication(String label, String field) {
        jurisdictionList.setCaption(label);
        List<Facility> facilities = FacilityFacade.getFacilityService().findAll();
        for (Facility facility : facilities) {
            jurisdictionList.setItemCaption(facility.getId(), facility.getFacilityName() + " IN  " + facility.getCity().getName());
            jurisdictionList.setNullSelectionAllowed(false);
            jurisdictionList.setMultiSelect(true);
            jurisdictionList.addItem(facility.getId());
        }
        jurisdictionList.setWidth("250px");
        binder.bind(jurisdictionList, field);
        return jurisdictionList;
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
