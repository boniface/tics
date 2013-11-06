/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.password;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.password.tabs.PasswordTab;

/**
 *
 * @author boniface
 */
public class PasswordMenu extends Menu {

    public PasswordMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout changePasswordTab = new VerticalLayout();
        changePasswordTab.setMargin(true);
        changePasswordTab.addComponent(new PasswordTab(getMain()));

        getTab().addTab(changePasswordTab, "Change Password", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(changePasswordTab);
                break;
        }
        addComponent(getTab());

    }
}
