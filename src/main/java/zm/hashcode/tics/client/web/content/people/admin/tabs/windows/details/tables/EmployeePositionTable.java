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
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.EmployeePositionForm;
import zm.hashcode.tics.domain.people.EmployeePosition;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author geek
 */
public class EmployeePositionTable extends Table {

    private final TicsMain main;
    private final Person person;
    private final VerticalLayout content;
    private EmployeePositionForm form;

    public EmployeePositionTable(final TicsMain main, final Person person, final VerticalLayout content) {
        this.main = main;
        this.person = person;
        this.content = content;
///    @DBRef
//    private String positionId; // Position
//    private Date startDate;
//    private Date enddate;
//    private String status;

        addContainerProperty("Postion", String.class, null);
        addContainerProperty("Status", String.class, null);
        addContainerProperty("Start Date", Date.class, null);
        addContainerProperty("End Date", Date.class, null);
        addContainerProperty("Edit", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<EmployeePosition> employeePositions = person.getPositions();
        int i = 1;
        for (EmployeePosition employeePosition : employeePositions) {

            Button deleteButton = new Button("Delete");
            deleteButton.setData(employeePosition);
            deleteButton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EmployeePosition itemId = (EmployeePosition) event.getButton().getData();
                    System.out.println(" The is ia " + itemId.getPosition().getPositionTitle() + " " + itemId.getStatus());
                    List<EmployeePosition> updatedEmployeePositions = removeEntity(itemId, person.getPositions());
                    Person updatedPerson = new Person.Builder(person.getFirstname(), person.getSurname())
                            .person(person)
                            .positions(updatedEmployeePositions)
                            .build();
                    PersonFacade.getPersonService().merge(updatedPerson);
                    getHome();

                }
            });

            deleteButton.setStyleName(Reindeer.BUTTON_LINK);

            Button editbutton = new Button("Edit");
            editbutton.setData(employeePosition);
            editbutton.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    // Get the item identifier from the user-defined data.
                    EmployeePosition itemId = (EmployeePosition) event.getButton().getData();
                    form = new EmployeePositionForm(main, person, content);
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
                employeePosition.getPosition().getPositionTitle(),
                employeePosition.getStatus(),
                employeePosition.getStartDate(),
                employeePosition.getEnddate(),
                editbutton,
                deleteButton
            }, i);
        }

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    public List<EmployeePosition> removeEntity(final EmployeePosition employeePosition, List<EmployeePosition> employeePositions) {
        return ImmutableList.copyOf(Collections2.filter(employeePositions, Predicates.not(Predicates.equalTo(employeePosition))));
    }

    private void getHome() {
        content.removeAllComponents();
        Person personn = PersonFacade.getPersonService().find(person.getId());
        EmployeePositionTable updatetable = new EmployeePositionTable(main, personn, content);
        content.addComponent(updatetable);
    }
}
