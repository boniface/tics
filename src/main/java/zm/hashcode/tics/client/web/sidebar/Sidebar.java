/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.app.security.GetUserCredentials;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.services.users.predicates.RolesEnum;

/**
 *
 * @author boniface
 */
public class Sidebar extends Accordion {

    final GetUserCredentials creds = new GetUserCredentials();
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
        setHeight("350px");
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
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(homeMenu, HOME_PAGE, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(peopleMenu, MANAGE_PEOPLE, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_TRAINER.name())) {
            addTab(trainingMenu, MANAGE_TRAINING, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(reportsMenu, GENERATE_REPORT, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(usersMenu, MANAGE_USERS, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(setupMenu, SYSTEM_SETUP, null);
        }
        if (creds.isUserWithRole(RolesEnum.ROLE_ADMIN.name())) {
            addTab(passwordMenu, CHANGE_PASSWORD, null);
        }


    }
}
