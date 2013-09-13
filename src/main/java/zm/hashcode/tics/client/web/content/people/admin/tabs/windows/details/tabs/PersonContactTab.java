/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tabs;

import com.vaadin.server.AbstractErrorMessage;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.PersonContactForm;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.PersonContactsTable;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PersonContactTab extends VerticalLayout implements Button.ClickListener {

    private final TicsMain main;
    private PersonContactForm form;
    private HorizontalLayout header = new HorizontalLayout();
    private VerticalLayout contentLayout = new VerticalLayout();
    private Button button = new Button("Add Contact");
    private final PersonContactsTable table;
    private final Person person;

    public PersonContactTab(TicsMain main, Person person) {
        this.main = main;
        this.person = person;
        header.setSizeFull();
        button.setStyleName("default");
        button.addClickListener(this);
        header.addComponent(button);
        header.setComponentAlignment(button, Alignment.TOP_RIGHT);
        table = new PersonContactsTable(main, person, contentLayout);
        table.setSizeFull();
        addComponent(header);
        addComponent(new Label("<hr/>", ContentMode.HTML));
        contentLayout.addComponent(table);
        addComponent(contentLayout);

    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        form = new PersonContactForm(main, person, contentLayout);
        contentLayout.removeAllComponents();
        contentLayout.addComponent(form);

    }
}
