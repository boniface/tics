/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import zm.hashcode.tics.client.web.content.system.facility.model.FacilityTypeBean;

/**
 *
 * @author ColinWa
 */
public class FacilityTypeForm extends FormLayout {

    private final FacilityTypeBean bean;
    public final BeanItem<FacilityTypeBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public FacilityTypeForm() {
        bean = new FacilityTypeBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField facilityName = getTextField("Facility Name", "facilityName");
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(facilityName, 0, 0);
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(FacilityTypeBean.class, field));
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
