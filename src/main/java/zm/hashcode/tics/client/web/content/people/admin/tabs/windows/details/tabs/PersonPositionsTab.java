/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tabs;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author boniface
 */
public class PersonPositionsTab extends VerticalLayout {

    private final TicsMain main;
    private HorizontalLayout header = new HorizontalLayout();
    private Button button = new Button();

    public PersonPositionsTab(TicsMain main) {
        this.main = main;
        header.setSizeFull();
        header.addComponent(button);

    }
}
