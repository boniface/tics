/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tables.AdministerPeopleTable;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.NewPersonWindow;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class ManagePeopleTab extends VerticalLayout implements
        Button.ClickListener {

    private final TicsMain main;
    private final HorizontalLayout headerBar = new HorizontalLayout();
    public final VerticalLayout contentPanel = new VerticalLayout();
    private final Button addPerson = new Button("Add Person");
    private final TextField peopleSearchBox = new TextField(" Search For Person");
    private AdministerPeopleTable table;
    private final List<Person> personList = PersonFacade.getPersonService().findAll();

    public ManagePeopleTab(TicsMain main) {
        this.main = main;

        contentPanel.setSizeFull();
        peopleSearchBox.setInputPrompt("Search for Person");
        addListeners();
        table = new AdministerPeopleTable(main, this, personList);
        headerBar.setSizeFull();
        headerBar.addComponent(peopleSearchBox);
        headerBar.setExpandRatio(peopleSearchBox, 1);
        headerBar.setComponentAlignment(peopleSearchBox, Alignment.MIDDLE_LEFT);
        headerBar.addComponent(addPerson);
        headerBar.setComponentAlignment(addPerson, Alignment.MIDDLE_RIGHT);
        headerBar.setComponentAlignment(peopleSearchBox, Alignment.MIDDLE_LEFT);
        addPerson.setWidth("200px");
        peopleSearchBox.setWidth("400px");
        addComponent(headerBar);
        addComponent(new Label("<HR/>", ContentMode.HTML));
        contentPanel.removeAllComponents();
        contentPanel.addComponent(table);
        addComponent(contentPanel);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        final Button source = event.getButton();
        if (source == addPerson) {
            contentPanel.removeAllComponents();
            contentPanel.addComponent(new NewPersonWindow(main));
        }
    }

    private void addListeners() {
        addPerson.addClickListener((Button.ClickListener) this);
        peopleSearchBox.addTextChangeListener(new TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                table.removeAllItems();
                System.out.println(" THE Text Entered " + event.getText());

                List<Person> list = new ArrayList<>();
                for (Person person : personList) {
                    if (person.getSurname().toLowerCase().contains(event.getText().toLowerCase())) {
                        list.add(person);
                    }
                }
                table = new AdministerPeopleTable(main, ManagePeopleTab.this, list);
                contentPanel.removeAllComponents();
                contentPanel.addComponent(table);
            }
        });

        peopleSearchBox.addShortcutListener(new ShortcutListener("Clear",
                KeyCode.ESCAPE, null) {
            @Override
            public void handleAction(Object sender, Object target) {
                peopleSearchBox.setValue("");
                table = new AdministerPeopleTable(main, ManagePeopleTab.this, personList);
                contentPanel.removeAllComponents();
                contentPanel.addComponent(table);
                System.out.println("THE VALUE HAS ");
//
            }
        });
    }
}
