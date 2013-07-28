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
import java.util.List;
import zm.hashcode.tics.app.facade.user.UserFacade;

import zm.hashcode.tics.client.web.content.users.models.ResetBean;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
public class ResetForm extends FormLayout {

    private final ResetBean bean;
    public final BeanItem<ResetBean> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button reset = new Button("RESET Password");
    public Button cancel = new Button("Cancel");
    public ComboBox comboBoxUsers;

    public ResetForm() {
        bean = new ResetBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        reset.setVisible(false);
        cancel.setVisible(false);
        comboBoxUsers = getComboBox(" Select User", "id");
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(comboBoxUsers, 0, 0);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(reset);
        buttons.addComponent(cancel);
        return buttons;
    }

    private ComboBox getComboBox(String label, String field) {
        ComboBox comboBox = new ComboBox(label);
        List<User> users = UserFacade.getUserService().findAll();
        for (User user : users) {
            comboBox.addItem(user.getId());
            comboBox.setItemCaption(user.getId(), user.getLastname() + " " + user.getFirstname() + "  EMAIL : " + user.getEmail());
        }
        comboBox.addValidator(new BeanValidator(ResetBean.class, field));
        comboBox.setImmediate(true);
        comboBox.setWidth(500, Unit.PIXELS);
        binder.bind(comboBox, field);
        return comboBox;
    }
}
