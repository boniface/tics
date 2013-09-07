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
import com.vaadin.ui.ComboBox;
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
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.model.ContactsBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.ContactsTable;
import zm.hashcode.tics.domain.people.Contact;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author geek
 */
public class PersonContactForm extends FormLayout implements Button.ClickListener, Property.ValueChangeListener {

    private final ContactsBean bean;
    public final BeanItem<ContactsBean> item;
    public final FieldGroup binder;
    public ComboBox cityCombo = new ComboBox();
    // Define Buttons
    public Button save = new Button("Save");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");
    private final Person person;
    private final TicsMain main;
    private final VerticalLayout content;
    private ContactsTable table;

    public PersonContactForm(TicsMain main, Person person, VerticalLayout contentLayout) {
        setSizeFull();
        this.person = person;
        this.main = main;
        this.content = contentLayout;

        addListeners();
        bean = new ContactsBean();
        item = new BeanItem<>(bean);
        binder = new FieldGroup(item);
        HorizontalLayout buttons = getButtons();
        // Determines which properties are shown
        update.setVisible(false);
        delete.setVisible(false);


        TextField mailingAddress = getTextField("Mailing Address", "mailingAddress");
        TextField telephoneNumber = getTextField("Physical Address", "telephoneNumber");
        TextField cellnumber = getTextField("Cell Number", "cellnumber");
        TextField faxnumber = getTextField("Fax Number", "faxnumber");
        TextField email = getTextField("Email", "email");
        TextField addressType = getTextField("Address Type", "addressType");
        GridLayout grid = new GridLayout(4, 10);
        grid.setSizeFull();

        grid.addComponent(email, 0, 0);
        grid.addComponent(cellnumber, 1, 0);
        grid.addComponent(telephoneNumber, 2, 0);

        grid.addComponent(faxnumber, 0, 1);
        grid.addComponent(mailingAddress, 1, 1);
        grid.addComponent(addressType, 2, 1);

        grid.addComponent(buttons, 0, 3, 2, 3);

        addComponent(grid);

    }

    private TextField getTextField(String label, String field) {
        TextField textField = new TextField(label);
        textField.setWidth(250, Unit.PIXELS);
        textField.setNullRepresentation("");
        textField.addValidator(new BeanValidator(ContactsBean.class, field));
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
        table.addValueChangeListener((Property.ValueChangeListener) this);
    }

    private void saveForm(FieldGroup binder) {
        try {
            binder.commit();
            Contact contact = getNewEntity(binder);
            List<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            contacts.addAll(person.getContacts());
            Person updatePerson = new Person.Builder(person.getFirstname(), person.getSurname())
                    .person(person)
                    .contacts(contacts)
                    .build();
            PersonFacade.getPersonService().merge(updatePerson);
            getHome();
            Notification.show("Record ADDED!", Notification.Type.TRAY_NOTIFICATION);
        } catch (FieldGroup.CommitException e) {
            Notification.show("Values MISSING!", Notification.Type.TRAY_NOTIFICATION);
            getHome();
        }


    }

    private void saveEditedForm(FieldGroup binder) {
        getHome();
    }

    private void deleteForm(FieldGroup binder) {
        getHome();
    }

    private void getHome() {
        content.removeAllComponents();
        table = new ContactsTable(main, person, content);
        content.addComponent(table);
    }

    private Contact getNewEntity(FieldGroup binder) {
        final ContactsBean entityBean = ((BeanItem<ContactsBean>) binder.getItemDataSource()).getBean();
        final Contact contact = new Contact.Builder(entityBean.getEmail())
                .addressType(entityBean.getAddressType())
                .cellnumber(entityBean.getCellnumber())
                .faxnumber(entityBean.getFaxnumber())
                .mailingAddress(entityBean.getMailingAddress())
                .telephoneNumber(entityBean.getTelephoneNumber())
                .build();
        return contact;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        final Property property = event.getProperty();
        System.out.println(" The value is " + property.getValue());
    }
}
