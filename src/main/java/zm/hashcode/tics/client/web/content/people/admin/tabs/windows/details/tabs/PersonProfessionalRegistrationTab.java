/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tabs;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.forms.ProfessionalRegistrationForm;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables.ProfessionalRegistrationTable;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PersonProfessionalRegistrationTab extends VerticalLayout implements Button.ClickListener {

    private final TicsMain main;
    private ProfessionalRegistrationForm form;
    private HorizontalLayout header = new HorizontalLayout();
    private VerticalLayout contentLayout = new VerticalLayout();
    private Button button = new Button("Add Professional Registration");
    private final ProfessionalRegistrationTable table;
    private final Person person;

    public PersonProfessionalRegistrationTab(TicsMain main, Person person) {
        this.main = main;
        this.person = person;
        header.setSizeFull();
        button.setStyleName("default");
        button.addClickListener(this);
        header.addComponent(button);
        header.setComponentAlignment(button, Alignment.TOP_RIGHT);
        table = new ProfessionalRegistrationTable(main, person, contentLayout);
        table.setSizeFull();
        addComponent(header);
        addComponent(new Label("<hr/>", ContentMode.HTML));
        contentLayout.addComponent(table);
        addComponent(contentLayout);

    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        form = new ProfessionalRegistrationForm(main, person, contentLayout);
        contentLayout.removeAllComponents();
        contentLayout.addComponent(form);

    }
}
