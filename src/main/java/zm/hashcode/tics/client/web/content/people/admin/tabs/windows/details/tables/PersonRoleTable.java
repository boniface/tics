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
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.PersonRoleForm;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonRoles;

/**
 *
 * @author geek
 */
public class PersonRoleTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private PersonRoleForm form;
    private static int selectedRowId;

    public PersonRoleTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("Role Name", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<PersonRoles> personRoles = person.getPersonRoles();
        int i = 1;
        for (PersonRoles personRole : personRoles) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(personRole);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    PersonRoles itemId = (PersonRoles) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getRoleName());
                    List<PersonRoles> updatedPersonRoles = removeEntity(itemId, person.getPersonRoles());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .personRoles(updatedPersonRoles)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(personRole);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {

                    //
//                    selectedRowId = Integer.parseInt(getValue().toString()); // get the row id
//                    System.out.println(" \n Selected Row id or key is " + selectedRowId + " ===============\n");
                    //
                    // Get the item identifier from the user-defined data.
                    PersonRoles itemId = (PersonRoles) event.getButton().getData();
                    form = new PersonRoleForm(main, person, content);
                    content.removeAllComponents();
                    form.setBean(itemId);//////////////////////////////////////////////////////////////
                    form.getSave().setVisible(false);
                    form.getUpdate().setVisible(true);
                    content.addComponent(form);

                }
            });

            editbutton.setStyleName(Reindeer.BUTTON_LINK);

            i++;
            addItem(new Object[]{
                personRole.getRoleName(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<PersonRoles> removeEntity(final PersonRoles personRole, List<PersonRoles> personRoless) {
        return ImmutableList.copyOf(Collections2.filter(personRoless, Predicates.not(Predicates.equalTo(personRole))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        PersonRoleTable updatetable = new PersonRoleTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
