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
import java.util.Date;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.ProfessionalRegistrationForm;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.ProfessionalRegistration;

/**
 *
 * @author geek
 */
public class ProfessionalRegistrationTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private ProfessionalRegistrationForm form;

    public ProfessionalRegistrationTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

//            private String registrationBodyId; // RegistrationBody  *********
//    private String registrationNumber;
//    private Date registrationDate;
//    private String licenceNumber;
//    private Date expirationDate;

        addContainerProperty("Registration Body", String.class, null);
        addContainerProperty("Registration Number", String.class, null);
        addContainerProperty("Registration Date", Date.class, null);
        addContainerProperty("Expiration Date", Date.class, null);
        addContainerProperty("Licence Number", String.class, null);

        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<ProfessionalRegistration> professionalRegistrations = person.getProfessionalRegistration();
        int i = 1;
        for (ProfessionalRegistration professionalRegistration : professionalRegistrations) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(professionalRegistration);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    ProfessionalRegistration itemId = (ProfessionalRegistration) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getRegistrationNumber() + " " + itemId.getLicenceNumber());
                    List<ProfessionalRegistration> updatedProfessionalRegistrations = removeEntity(itemId, person.getProfessionalRegistration());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .professionalRegistration(updatedProfessionalRegistrations)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(professionalRegistration);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    ProfessionalRegistration itemId = (ProfessionalRegistration) event.getButton().getData();
                    form = new ProfessionalRegistrationForm(main, person, content);
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
                professionalRegistration.getRegistrationBody().getName(),
                professionalRegistration.getRegistrationNumber(),
                professionalRegistration.getRegistrationDate(),
                professionalRegistration.getExpirationDate(),
                professionalRegistration.getLicenceNumber(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<ProfessionalRegistration> removeEntity(final ProfessionalRegistration professionalRegistration, List<ProfessionalRegistration> professionalRegistrations) {
        return ImmutableList.copyOf(Collections2.filter(professionalRegistrations, Predicates.not(Predicates.equalTo(professionalRegistration))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        ProfessionalRegistrationTable updatetable = new ProfessionalRegistrationTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
