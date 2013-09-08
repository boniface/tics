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
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.facade.ui.demographics.IdentificationTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;

/**
 *
 * @author geek
 */
public class PersonIdentitiesTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;

    public PersonIdentitiesTable(TicsMain main, final Person person, VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("ID Type", String.class, null);
        addContainerProperty("ID Value", String.class, null);

//    private String id;
//    private String identificationTypeId; // IdentificationType ***
//    private String idValue;

        List<PersonIdentities> personIdentities = person.getIdentities();
        int i = 1;
        for (PersonIdentities personIdentity : personIdentities) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(personIdentity);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    PersonIdentities itemId = (PersonIdentities) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getIdValue());
                    List<PersonIdentities> updatedPersonIdentities = removeEntity(itemId, person.getIdentities());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .identities(updatedPersonIdentities)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
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
                    PersonIdentities itemId = (PersonIdentities) event.getButton().getData();

                }
            });

            editbutton.setStyleName(Reindeer.BUTTON_LINK);

            i++;

            IdentificationType identificationType = IdentificationTypeFacade.getIdentificationTypeService().find(personIdentity.getIdType().getId());


            addItem(new Object[]{
                identificationType.getIdvalue(),
                personIdentity.getIdValue(),
                editbutton,
                deleteButton
            }, i);
        }


        setNullSelectionAllowed(
                false);
//
        setSelectable(
                true);
        // Send changes in selection immediately to server.
        setImmediate(
                true);

    }

    public List<PersonIdentities> removeEntity(final PersonIdentities personIdentity, List<PersonIdentities> personIdentities) {
        return ImmutableList.copyOf(Collections2.filter(personIdentities, Predicates.not(Predicates.equalTo(personIdentity))));
    }

    private void getHome() {
        content.removeAllComponents();
        PersonContactsTable updatetable = new PersonContactsTable(main, person, content);
        content.addComponent(updatetable);
    }
    //
}
