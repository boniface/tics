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
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.client.web.content.people.admin.forms.EditPersonForm;
import zm.hashcode.tics.client.web.content.people.admin.model.PersonBean;
import zm.hashcode.tics.client.web.content.people.admin.tabs.ManagePeopleTab;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.EditPersonWindow;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.PersonDetails;
import zm.hashcode.tics.client.web.content.people.admin.util.PersonUtil;
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

    public AdministerPeopleTable(final TicsMain main, final ManagePeopleTab peopleTab, List<Person> personlist) {
        this.main = main;

        setSizeFull();

        addContainerProperty("Title", String.class, null);
        addContainerProperty("Surname", String.class, null);
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Other Name", String.class, null);
        addContainerProperty("Gender", String.class, null);
        addContainerProperty("Details", Button.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        for (Person person : personlist) {

            Button editField = new Button("Edit");
            editField.setData(person.getId());
            editField.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    String itemId = (String) event.getButton().getData();
                    Person person = PersonFacade.getPersonService().find(itemId);
                    PersonBean bean = new PersonUtil().getBean(person);
                    EditPersonForm form = new EditPersonForm(bean);

                    peopleTab.contentPanel.removeAllComponents();
                    peopleTab.contentPanel.addComponent(new EditPersonWindow(main, form));


                }
            });

            Button detailsField = new Button("Show details");
            detailsField.setData(person.getId());
            detailsField.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    String itemId = (String) event.getButton().getData();
                    Person person = PersonFacade.getPersonService().find(itemId);
                    peopleTab.contentPanel.removeAllComponents();
                    peopleTab.contentPanel.addComponent(new PersonDetails(main, person));

                }
            });

            Button deleteButton = new Button("Delete");
            deleteButton.setData(person.getId());
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    String itemId = (String) event.getButton().getData();
                    Person person = PersonFacade.getPersonService().find(itemId);
                    PersonUtil.deletePerson(person);

                    getHome();


                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);
            editField.setStyleName(Reindeer.BUTTON_LINK);
            detailsField.setStyleName(Reindeer.BUTTON_LINK);

            addItem(new Object[]{
                getTitle(person.getTitle()),
                person.getSurname(),
                person.getFirstname(),
                person.getOthername(),
                getGender(person.getDemography()),
                detailsField,
                editField,
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

    private void getHome() {
        main.content.setSecondComponent(new AdministerMenu(main, "LANDING"));
    }
}
