/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author boniface
 */
public class ManageMentoringTab extends VerticalLayout {

    private final TicsMain main;
    private final HorizontalLayout headerBar = new HorizontalLayout();
    private final Button addPerson = new Button("Add Person");
    private final ComboBox peopleSearchBox = new ComboBox(" Seaarch For Person");

    public ManageMentoringTab(TicsMain main) {
        this.main = main;
        headerBar.setSizeFull();
        headerBar.addComponent(peopleSearchBox);
        headerBar.addComponent(addPerson);
        headerBar.setComponentAlignment(addPerson, Alignment.MIDDLE_RIGHT);
        headerBar.setComponentAlignment(peopleSearchBox, Alignment.MIDDLE_LEFT);
        addPerson.setWidth("200px");
        peopleSearchBox.setWidth("400px");

        addComponent(headerBar);

    }
}
