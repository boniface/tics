/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.forms;

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
import zm.hashcode.tics.app.facade.training.mentoring.MentoringFieldFacade;
import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringThemeBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;

/**
 *
 * @author geek
 */
public class MentoringThemeForm extends FormLayout {

    private final MentoringThemeBean bean;
    public final BeanItem<MentoringThemeBean> item;
    public final FieldGroup binder;
    //
    public ComboBox mentoringFieldCombo = new ComboBox();
    //
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");

    public MentoringThemeForm() {
        bean = new MentoringThemeBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        //
        final TextField mentoringThemeTextField = getTextField("Mentoring Theme", "mentoringTheme");
        final ComboBox mentoringFieldComboBox = getMentoringFieldComboBox("Mentoring Field", "mentoringFieldId");
        //
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(mentoringThemeTextField, 0, 0);
        grid.addComponent(mentoringFieldComboBox, 1, 0);
        grid.addComponent(buttons, 0, 1, 2, 1);

        addComponent(grid);
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(MentoringThemeBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private ComboBox getMentoringFieldComboBox(String label, String field) {
        mentoringFieldCombo.setCaption(label);
        List<MentoringField> mentoringFields = MentoringFieldFacade.getMentoringFieldService().findAll();
        for (MentoringField mentoringField : mentoringFields) {
            mentoringFieldCombo.addItem(mentoringField.getId());
            mentoringFieldCombo.setItemCaption(mentoringField.getId(), mentoringField.getFieldName());
        }
        mentoringFieldCombo.addValidator(new BeanValidator(MentoringThemeBean.class, field));
        mentoringFieldCombo.setImmediate(true);
        mentoringFieldCombo.setWidth(250, Unit.PIXELS);
        binder.bind(mentoringFieldCombo, field);
        return mentoringFieldCombo;
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
