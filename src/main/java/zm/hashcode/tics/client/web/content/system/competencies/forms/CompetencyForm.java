/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.forms;

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
import zm.hashcode.tics.app.facade.training.competencies.CompetencyTypeFacade;
import zm.hashcode.tics.client.web.content.system.competencies.model.CompetencyBean;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author geek
 */
public class CompetencyForm extends FormLayout {

    private final CompetencyBean bean;
    public final BeanItem<CompetencyBean> item;
    public final FieldGroup binder;
    public ComboBox competencyTypeIdCombo = new ComboBox();
//    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
//

    public CompetencyForm() {
        bean = new CompetencyBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

//    private String id;
//    private String name;
//    @DBRef
//    private CompetencyType type;
//    private String notes;

        TextField name = getTextField("Competency Name", "name");
        ComboBox competencyTypeIdComboBox = getComboBox("Competency Type", "competencyTypeId");
        TextField notes = getTextField("Notes", "notes");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(competencyTypeIdComboBox, 1, 0);
        grid.addComponent(notes, 2, 0);

        grid.addComponent(buttons, 0, 1, 2, 1); // 0, 3, 2, 3

        addComponent(grid);
    }

    private ComboBox getComboBox(String label, String field) {
        competencyTypeIdCombo.setCaption(label);
        List<CompetencyType> competencyTypes = CompetencyTypeFacade.getCompetencyTypeService().findAll();
        for (CompetencyType iCompetencyType : competencyTypes) {
            competencyTypeIdCombo.addItem(iCompetencyType.getId());
            competencyTypeIdCombo.setItemCaption(iCompetencyType.getId(), iCompetencyType.getName());
        }
        competencyTypeIdCombo.addValidator(new BeanValidator(CompetencyBean.class, field));
        competencyTypeIdCombo.setImmediate(true);
        competencyTypeIdCombo.setWidth(250, Unit.PIXELS);
        binder.bind(competencyTypeIdCombo, field);
        return competencyTypeIdCombo;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(CompetencyBean.class, field));
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
