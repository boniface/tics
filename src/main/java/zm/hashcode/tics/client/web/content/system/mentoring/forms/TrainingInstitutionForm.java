/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.forms;

import com.google.common.collect.Collections2;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.user.UserFacade;
import zm.hashcode.tics.client.web.content.system.traininginstitution.model.TrainingInstitutionBean;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.services.users.predicates.TrainerPredicate;

/**
 *
 * @author geek
 */
public class TrainingInstitutionForm extends FormLayout {

    private final TrainingInstitutionBean bean;
    public final BeanItem<TrainingInstitutionBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    //
//    public ComboBox locationCombo = new ComboBox();
    public ListSelect usersList = new ListSelect();

    public TrainingInstitutionForm() {
        bean = new TrainingInstitutionBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);

        TextField name = getTextField("Name", "name");
        final ListSelect usersIds = getUsersListSelect("Select Users", "usersIds");

        GridLayout grid = new GridLayout(4, 10);  // ADJUSTS if neccesary Col, Row
        grid.setSizeFull();

        grid.addComponent(name, 0, 0);
        grid.addComponent(usersIds, 0, 1);

        grid.addComponent(buttons, 0, 4, 2, 4);
        addComponent(grid);

    }

    private ListSelect getUsersListSelect(String label, String field) {
        usersList.setCaption(label);
        List<User> users = UserFacade.getUserService().findAll();
        Collection<User> trainers = Collections2.filter(users, new TrainerPredicate());
        for (User user : trainers) {
            usersList.setItemCaption(user.getId(), user.getFirstname() + " " + user.getLastname());
            usersList.setNullSelectionAllowed(false);
            usersList.setMultiSelect(true);
            usersList.addItem(user.getId());
        }
        usersList.setWidth("250px");
        binder.bind(usersList, field);

        return usersList;
    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(TrainingInstitutionBean.class, field));
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
