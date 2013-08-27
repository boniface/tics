/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tables;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author boniface
 */
public class AdministerPeopleTable extends Table {

    private final TicsMain main;

    public AdministerPeopleTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Title", String.class, null);
        addContainerProperty("Surname", String.class, null);
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Other Name", String.class, null);
        addContainerProperty("Gender", String.class, null);
        addContainerProperty("Details", Button.class, null);
        addContainerProperty("Delete", Button.class, null);


        List<Person> personlist = PersonFacade.getPersonService().findAll();
        for (Person person : personlist) {

            Button detailsField = new Button("Show details");
            detailsField.setData(person.getId());
            detailsField.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    Long itemId = (Long) event.getButton().getData();

                }
            });

            Button deleteButton = new Button("Delete");
            deleteButton.setData(person.getId());
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    Long itemId = (Long) event.getButton().getData();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);
            detailsField.setStyleName(Reindeer.BUTTON_LINK);

            addItem(new Object[]{
                getTitle(person.getTitle()),
                person.getSurname(),
                person.getFirstname(),
                person.getOthername(),
                getGender(person.getDemography()),
                detailsField,
                deleteButton
            }, person.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getTitle(Title title) {
        if (title != null) {
            return title.getTitle();
        }
        return null;
    }

    private String getGender(Demography demography) {
        if (demography != null) {
            return getGenderValue(demography.getGender());
        }
        return null;
    }

    private String getGenderValue(Gender gender) {
        if (gender != null) {
            return gender.getGender();
        }
        return null;
    }
}
