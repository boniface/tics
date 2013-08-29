/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.tables.AdministerPeopleTable;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.NewPersonWindow;

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
    private final ComboBox peopleSearchBox = new ComboBox(" Seaarch For Person");
    private final AdministerPeopleTable table;

    public ManagePeopleTab(TicsMain main) {
        this.main = main;
        contentPanel.setSizeFull();
        addListeners();
        table = new AdministerPeopleTable(main, this);
        headerBar.setSizeFull();
        headerBar.addComponent(peopleSearchBox);
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
    }
}
