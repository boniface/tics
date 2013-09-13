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
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.people.PersonIdentitiesFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.PersonIdentitiesForm;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;

/**
 *
 * @author geek
 */
public class PersonIdentitiesTable extends Table {

    public final TicsMain main;
    public final Person person;
    public final VerticalLayout content;
    private PersonIdentitiesForm form;

    public PersonIdentitiesTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("ID Type", String.class, null);
        addContainerProperty("ID Value", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);
//        try {
        List<PersonIdentities> personIdentities = this.person.getIdentities();
//        int i = 1;
        for (PersonIdentities personIdentity : personIdentities) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(personIdentity);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    PersonIdentities itemId = (PersonIdentities) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getIdValue());
                    ////////////////////////////////
                    List<PersonIdentities> updatedPersonIdentities = new ArrayList<>();
                    updatedPersonIdentities.addAll(person.getIdentities());
                    updatedPersonIdentities.remove(itemId);
                    ////////////////////////////////////
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .identities(updatedPersonIdentities) // updatedPersonIdentities
                            .id(person.getId())
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    PersonIdentitiesFacade.getPersonIdentitiesService().remove(itemId); // NOTE
                    getHome();

                }
            });
            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(personIdentity);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    PersonIdentities itemIdd = (PersonIdentities) event.getButton().getData();
                    form = new PersonIdentitiesForm(main, person, content);
                    content.removeAllComponents();
                    form.setBean(itemIdd);
                    form.getSave().setVisible(false);
                    form.getUpdate().setVisible(true);
                    content.addComponent(form);
                }
            });
            editbutton.setStyleName(Reindeer.BUTTON_LINK);

//            i++;
            addItem(new Object[]{
                personIdentity.getIdType().getIdvalue(),
                personIdentity.getIdValue(),
                editbutton,
                deleteButton
            }, personIdentity.getId()); //   }, i);
        }
        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
//        } catch (NullPointerException ex) {
//        }
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        PersonIdentitiesTable updatetable = new PersonIdentitiesTable(main, personn, content);
        content.addComponent(updatetable);
    }
    //
}
