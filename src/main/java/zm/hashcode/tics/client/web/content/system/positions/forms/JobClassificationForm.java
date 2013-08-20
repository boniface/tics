/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.FormLayout;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import zm.hashcode.tics.client.web.content.system.positions.model.JobClassificationBean;

/**
 *
 * @author geek
 */
public class JobClassificationForm extends FormLayout {

    private final JobClassificationBean bean;
    public final BeanItem<JobClassificationBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public JobClassificationForm() {
        bean = new JobClassificationBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField currentTitle = getTextField("Current Title", "currentTitle");
        TextField oldTitle = getTextField("Old Title", "oldTitle");
        TextField oldCode = getTextField("Old Code", "oldCode");
        TextField currentCode = getTextField("Current Code", "currentCode");
        TextField codeConversion = getTextField("Code Conversion", "codeConversion");
        TextField comment = getTextField("Comment", "comment");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(currentTitle, 0, 0);
        grid.addComponent(oldTitle, 0, 1);
        grid.addComponent(oldCode, 0, 2);
        grid.addComponent(currentCode, 1, 0);
        grid.addComponent(codeConversion, 1, 1);
        grid.addComponent(comment, 1, 2);
        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(JobClassificationBean.class, field));
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
