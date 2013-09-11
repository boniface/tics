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
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.EducationHistoryForm;
import zm.hashcode.tics.domain.people.EducationHistory;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author geek
 */
public class EducationHistoryTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private EducationHistoryForm form;

    public EducationHistoryTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("Institute Name", String.class, null);
        addContainerProperty("Graduation Date", Date.class, null);
        addContainerProperty("major", String.class, null);
        addContainerProperty("Location", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<EducationHistory> educationHistorys = person.getEducationHistory();
        int i = 1;
        for (EducationHistory educationHistory : educationHistorys) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(educationHistory);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EducationHistory itemId = (EducationHistory) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getInstituteName() + " " + itemId.getMajor());
                    List<EducationHistory> updatedEducationHistorys = removeEntity(itemId, person.getEducationHistory());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .educationHistory(updatedEducationHistorys)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(educationHistory);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EducationHistory itemId = (EducationHistory) event.getButton().getData();
                    form = new EducationHistoryForm(main, person, content);
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
                educationHistory.getInstituteName(),
                educationHistory.getGraduationDate(),
                educationHistory.getMajor(),
                educationHistory.getLocation().getName(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<EducationHistory> removeEntity(final EducationHistory educationHistory, List<EducationHistory> educationHistorys) {
        return ImmutableList.copyOf(Collections2.filter(educationHistorys, Predicates.not(Predicates.equalTo(educationHistory))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        EducationHistoryTable updatetable = new EducationHistoryTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
