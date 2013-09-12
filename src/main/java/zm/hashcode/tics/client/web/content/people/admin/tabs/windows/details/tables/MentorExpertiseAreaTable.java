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
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.MentorExpertiseAreaForm;
import zm.hashcode.tics.domain.people.MentorExpertiseArea;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author geek
 */
public class MentorExpertiseAreaTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private MentorExpertiseAreaForm form;
//    private static int selectedRowId;

    public MentorExpertiseAreaTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;

        addContainerProperty("Expertise Area Name", String.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<MentorExpertiseArea> mentorExpertiseAreas = person.getMentorExpertiseAreas();
        int i = 1;
        for (MentorExpertiseArea mentorExpertiseArea : mentorExpertiseAreas) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(mentorExpertiseArea);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    MentorExpertiseArea itemId = (MentorExpertiseArea) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getExpertiseAreaName());
                    List<MentorExpertiseArea> updatedMentorExpertiseAreas = removeEntity(itemId, person.getMentorExpertiseAreas());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .mentorExpertiseAreas(updatedMentorExpertiseAreas)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(mentorExpertiseArea);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {

                    //
//                    selectedRowId = Integer.parseInt(getValue().toString()); // get the row id
//                    System.out.println(" \n Selected Row id or key is " + selectedRowId + " ===============\n");
                    //
                    // Get the item identifier from the user-defined data.
                    MentorExpertiseArea itemId = (MentorExpertiseArea) event.getButton().getData();
                    form = new MentorExpertiseAreaForm(main, person, content);
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
                mentorExpertiseArea.getExpertiseAreaName(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<MentorExpertiseArea> removeEntity(final MentorExpertiseArea mentorExpertiseArea, List<MentorExpertiseArea> mentorExpertiseAreas) {
        return ImmutableList.copyOf(Collections2.filter(mentorExpertiseAreas, Predicates.not(Predicates.equalTo(mentorExpertiseArea))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        MentorExpertiseAreaTable updatetable = new MentorExpertiseAreaTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
