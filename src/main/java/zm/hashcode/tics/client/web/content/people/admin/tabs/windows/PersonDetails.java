/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows;

import com.vaadin.ui.Button;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.people.admin.AdministerMenu;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.DemographicsWIndow;
import zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tabs.TabPanel;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class PersonDetails extends VerticalLayout {

    private final TicsMain main;
    private TabSheet tab;
    private final Button backtoMainPage = new Button("Back to Main Page");

    public PersonDetails(TicsMain main, Person person) {
        setSizeFull();
        this.main = main;
        backtoMainPage.setSizeFull();

        addComponent(new DemographicsWIndow(main, person));
        addComponent(new TabPanel(main, "LANDING", person));
        addComponent(backtoMainPage);
        backtoMainPage.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getHome();


            }
        });

    }

    private void getHome() {
        main.content.setSecondComponent(new AdministerMenu(main, "LANDING"));
    }
}
