/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import java.util.Date;
import zm.hashcode.tics.client.web.content.system.facility.model.RegistrationBodyBean;

/**
 *
 * @author geek
 */
public class RegistrationBodyForm extends FormLayout {

    private final RegistrationBodyBean bean;
    public final BeanItem<RegistrationBodyBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public RegistrationBodyForm() {
        bean = new RegistrationBodyBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);



//                private String id;
//    @NotNull
//    private String name;
//    private String description;
//    private String coreActivity;
//    private String active;
//    @NotNull
//    private Date startDate

        TextField name = getTextField("Name", "name");
        TextField description = getTextField("Description", "description");
        TextField coreActivity = getTextField("Core Activity", "coreActivity");
        TextField active = getTextField("Active", "active");
        PopupDateField startDate = getPopupDateField("StartDate", "startDate");
//         final CheckBox enable = getCheckBoxField("Activate Account", "enabled");



        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(description, 1, 0);
        grid.addComponent(coreActivity, 2, 0);
        grid.addComponent(active, 0, 1);
        grid.addComponent(startDate, 1, 1);
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(RegistrationBodyBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private PopupDateField getPopupDateField(String label, String field) {
        PopupDateField popupDateField = new PopupDateField(label);
        popupDateField.setWidth(250, Unit.PIXELS);
        popupDateField.addValidator(new BeanValidator(RegistrationBodyBean.class, field));
        popupDateField.setImmediate(true);
        binder.bind(popupDateField, field);
        return popupDateField;
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
