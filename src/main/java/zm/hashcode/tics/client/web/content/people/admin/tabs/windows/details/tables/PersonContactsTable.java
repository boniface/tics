/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.PersonContactForm;
import zm.hashcode.tics.domain.people.Contact;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PersonContactsTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private PersonContactForm form;

    public PersonContactsTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("Email", String.class, null);
        addContainerProperty("Cell", String.class, null);
        addContainerProperty("Telephone", String.class, null);
        addContainerProperty("Fax", String.class, null);
        addContainerProperty("Mailing Address", String.class, null);
        addContainerProperty("Address Type", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<Contact> contacts = person.getContacts();
        int i = 1;
        for (Contact contact : contacts) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(contact);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    Contact itemId = (Contact) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getEmail());
                    List<Contact> updatedContacts = removeEntity(itemId, person.getContacts());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .contacts(updatedContacts)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(contact);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    Contact itemId = (Contact) event.getButton().getData();
                    form = new PersonContactForm(main, person, content);
                    content.removeAllComponents();
                    form.setBean(itemId);
                    form.getSave().setVisible(false);
                    form.getUpdate().setVisible(true);
                    content.addComponent(form);

                }
            });

            editbutton.setStyleName(Reindeer.BUTTON_LINK);

            i++;
            addItem(new Object[]{
                contact.getEmail(),
                contact.getCellnumber(),
                contact.getTelephoneNumber(),
                contact.getFaxnumber(),
                contact.getMailingAddress(),
                contact.getAddressType(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<Contact> removeEntity(final Contact contact, List<Contact> contacts) {
        return ImmutableList.copyOf(Collections2.filter(contacts, Predicates.not(Predicates.equalTo(contact))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        PersonContactsTable updatetable = new PersonContactsTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
