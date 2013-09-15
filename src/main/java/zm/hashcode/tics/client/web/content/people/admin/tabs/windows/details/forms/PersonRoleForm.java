/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms;

import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.PersonRoleBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.PersonRoleTable;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonRoles;

/**
 *
 * @author geek
 */
public class PersonRoleForm extends FormLayout
        implements Button.ClickListener, Property.ValueChangeListener {

    private final PersonRoleBean bean;
    public final BeanItem<PersonRoleBean> item;
    public final FieldGroup binder;
//    public ComboBox locationCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private PersonRoleTable table;
    private static String roleName;

    public PersonRoleForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;

        addListeners();
        bean = new PersonRoleBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);
//      private String roleName;
        TextField roleNameTextField = getTextField("Role Name", "roleName");

        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(roleNameTextField, 0, 0);

        grid.addComponent(buttons, 0, 2, 2, 2);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(PersonRoleBean.class, field));
        textField.setImmediate(true);
        binder.bind(textField, field);
        return textField;
    }

    private HorizontalLayout getButtons() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);
        return buttons;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == save) {
            saveForm(binder);
        } else if (source == cancel) {
            getHome();
        } else if (source == update) {
            saveEditedForm(binder);
        } else if (source == delete) {
            deleteForm(binder);
        }
    }

    private void addListeners() {
        //Register Button Listeners
        save.addClickListener((Button.ClickListener) this);
        cancel.addClickListener((Button.ClickListener) this);
        update.addClickListener((Button.ClickListener) this);
        delete.addClickListener((Button.ClickListener) this);
//        table.addValueChangeListener((Property.ValueChangeListener) this); // add later in getHome()
//        cityCombo.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private void saveForm(FieldGroup binder) {
        boolean matchFound = false;
        try {
            binder.commit();
            PersonRoles personRole = getNewEntity(binder);
            List<PersonRoles> personRoles = new ArrayList<>();

            List<PersonRoles> personRoless = person.getPersonRoles();
            for (PersonRoles personRolee : personRoless) {
                if (personRolee.getRoleName().equals(personRole.getRoleName()) || personRolee.getRoleName().equalsIgnoreCase(personRole.getRoleName())) {
                    matchFound = true;
                    Notification.show("Similar Record exist. Change before SAVING!", Notification.Type.TRAY_NOTIFICATION);
                    break;
                } else {
                    personRoles.add(personRolee);
                }
            }

            if (!matchFound) {
                personRoles.add(personRole);
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .personRoles(personRoles)
                        .id(person.getId())
                        .build();
                PersonFacade.getPersonService().merge(updatePerson);
                getHome();
                Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
            }
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }

    }

    private void saveEditedForm(FieldGroup binder) {
        boolean matchFound = false;
        try {
            binder.commit();
            PersonRoles personRole = getEditedEntity(binder);
            List<PersonRoles> personRoless = person.getPersonRoles();
            List<PersonRoles> updatedPersonRoles = new ArrayList<>();

            // Exclude current edited record from previous persisted records
            for (PersonRoles personRolee : personRoless) {
                if (!(personRolee.getRoleName().equals(roleName) || personRolee.getRoleName().equalsIgnoreCase(roleName))) {
                    updatedPersonRoles.add(personRolee); // Matching records to roleName should not be added. WORKS for ONE field embeddable
                }
            }

            // Compare with previous persisted records
            for (PersonRoles personRoles : updatedPersonRoles) {
                if (personRoles.getRoleName().equals(personRole.getRoleName()) || personRoles.getRoleName().equalsIgnoreCase(personRole.getRoleName())) {
                    matchFound = true;
                    Notification.show("Similar Record exist for Role Name!", Notification.Type.TRAY_NOTIFICATION);
                    break;
                }
            }
            if (!matchFound) {
                updatedPersonRoles.add(personRole);
                Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                        .person(person)
                        .personRoles(updatedPersonRoles)
                        .id(person.getId())
                        .build();
                PersonFacade.getPersonService().merge(updatePerson);
                getHome();
                Notification.show("Record UPDATED!", Notification.Type.TRAY_NOTIFICATION);
            }
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }

    }

    private void deleteForm(FieldGroup binder) {
        getHome();
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId()); // Get Person with current changes // refresh
        table = new PersonRoleTable(main, personn, content);
        content.addComponent(table);
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private PersonRoles getNewEntity(FieldGroup binder) {
        final PersonRoleBean entityBean = ((BeanItem<PersonRoleBean>) binder.getItemDataSource()).getBean();
        final PersonRoles educationHistory = new PersonRoles.Builder(entityBean.getRoleName())
                .build();
        return educationHistory;
    }

    private PersonRoles getEditedEntity(FieldGroup binder) {
        final PersonRoleBean entityBean = ((BeanItem<PersonRoleBean>) binder.getItemDataSource()).getBean();
        final PersonRoles educationHistory = new PersonRoles.Builder(entityBean.getRoleName())
                .build();
        return educationHistory;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
    }

    public void setBean(PersonRoles personRole) {
        item.getBean().setRoleName(personRole.getRoleName());
        roleName = personRole.getRoleName();
    }

    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @return the save
     */
    public Button getSave() {
        return save;
    }
}
