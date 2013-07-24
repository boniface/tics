/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author boniface
 */
public class Sidebar extends Accordion {

    private final TicsMain main;
    public static final String HOME_CONTENT = "HOME ";
    public static final String MANAGE_USERS = "Manage USERS";

    public Sidebar(TicsMain app) {
        setSizeFull();
        setHeight("600px");
        this.main = app;

        //Configure Manage People Menu
        VerticalLayout homeMenu = new VerticalLayout();
        HomeTree homeTree = new HomeTree(main);
        homeMenu.addComponent(homeTree);

        VerticalLayout usersMenu = new VerticalLayout();
        UserTree usersTree = new UserTree(main);
        usersMenu.addComponent(usersTree);


        // Add the components as tabs in the Accordion.
        addTab(homeMenu, HOME_CONTENT, null);
        addTab(usersTree, MANAGE_USERS, null);


    }
}
