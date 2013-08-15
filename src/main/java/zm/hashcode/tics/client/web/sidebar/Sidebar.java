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
    public static final String HOME_PAGE = "Home PAGE ";
    public static final String MANAGE_PEOPLE = "Manage PEOPLE ";
    public static final String MANAGE_TRAINING = "Manage TRAINING";
    public static final String CHANGE_PASSWORD = "Change PASSWORD ";
    public static final String MANAGE_USERS = "Manage USERS";
    public static final String GENERATE_REPORT = "Generate REPORTS";
    public static final String SYSTEM_SETUP = "System SETUP ";

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

        VerticalLayout peopleMenu = new VerticalLayout();
        PeopleTree peopleTree = new PeopleTree(main);
        peopleMenu.addComponent(peopleTree);

        VerticalLayout trainingMenu = new VerticalLayout();
        TrainingTree trainingTree = new TrainingTree(main);
        trainingMenu.addComponent(trainingTree);

        VerticalLayout passwordMenu = new VerticalLayout();
        PasswordTree passwordTree = new PasswordTree(main);
        passwordMenu.addComponent(passwordTree);

        VerticalLayout reportsMenu = new VerticalLayout();
        ReportsTree reportsTree = new ReportsTree(main);
        reportsMenu.addComponent(reportsTree);

        VerticalLayout setupMenu = new VerticalLayout();
        SystemTree setupTree = new SystemTree(main);
        setupMenu.addComponent(setupTree);


        // Add the components as tabs in the Accordion.
        addTab(homeMenu, HOME_PAGE, null);
        addTab(peopleMenu, MANAGE_PEOPLE, null);
        addTab(trainingMenu, MANAGE_TRAINING, null);
        addTab(passwordMenu, CHANGE_PASSWORD, null);
        addTab(reportsMenu, GENERATE_REPORT, null);
        addTab(usersMenu, MANAGE_USERS, null);
        addTab(setupMenu, SYSTEM_SETUP, null);



    }
}
