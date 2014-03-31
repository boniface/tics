/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tabs;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.Person;

/**
 *
 * @author boniface
 */
public class TabPanel extends VerticalLayout {

    private TabSheet tab;
    private final TicsMain main;

    public TabPanel(TicsMain main, String selectedTab, Person person) {
        this.main = main;
        tab = new TabSheet();
        tab.setHeight("100%");
        tab.setWidth("100%");

        final VerticalLayout contactTab = new VerticalLayout();
        contactTab.setMargin(true);
        contactTab.addComponent(new PersonContactTab(main, person));

        final VerticalLayout actionPlansTab = new VerticalLayout();
        actionPlansTab.setMargin(true);
        actionPlansTab.addComponent(new PersonActionPlansTab(main, person));

        final VerticalLayout personCoursesTab = new VerticalLayout();
        personCoursesTab.setMargin(true);
        personCoursesTab.addComponent(new PersonCoursesTab(main));

        final VerticalLayout personEducationTab = new VerticalLayout();
        personEducationTab.setMargin(true);
        personEducationTab.addComponent(new PersonEducationHistoryTab(main, person));

        final VerticalLayout personExpertiseTab = new VerticalLayout();
        personExpertiseTab.setMargin(true);
        personExpertiseTab.addComponent(new PersonMentorExpertiseAreaTab(main, person));

        final VerticalLayout personIdetitiesTab = new VerticalLayout();
        personIdetitiesTab.setMargin(true);
        personIdetitiesTab.addComponent(new PersonIdentitiesTab(main, person));

        final VerticalLayout personMenteesTab = new VerticalLayout();
        personMenteesTab.setMargin(true);
        personMenteesTab.addComponent(new PersonMenteesTab(main));

        final VerticalLayout personMentoringTab = new VerticalLayout();
        personMentoringTab.setMargin(true);
        personMentoringTab.addComponent(new PersonMentoringTab(main));

        final VerticalLayout persoPositionTab = new VerticalLayout();
        persoPositionTab.setMargin(true);
        persoPositionTab.addComponent(new PersonPositionsTab(main, person));

        final VerticalLayout personRolesTab = new VerticalLayout();
        personRolesTab.setMargin(true);
        personRolesTab.addComponent(new PersonRolesTab(main, person));

        final VerticalLayout personregistrationsTab = new VerticalLayout();
        personregistrationsTab.setMargin(true);
        personregistrationsTab.addComponent(new PersonProfessionalRegistrationTab(main, person));

        final VerticalLayout personFileUploadsTabs = new VerticalLayout();
        personFileUploadsTabs.setMargin(true);
        personFileUploadsTabs.addComponent(new PersonFileUploadsTabs(main, person));

        tab.addTab(contactTab, "Contacts", null);
        tab.addTab(personCoursesTab, "Courses", null);
        tab.addTab(actionPlansTab, "Action Plans", null);
        tab.addTab(personMentoringTab, "Mentoring", null);

        tab.addTab(personIdetitiesTab, "IDs", null);
        tab.addTab(personEducationTab, "Education", null);
        tab.addTab(persoPositionTab, "Positions", null);

        tab.addTab(personRolesTab, "Roles", null);
        
        tab.addTab(personregistrationsTab, "Registrations", null);
        
        tab.addTab(personExpertiseTab, "Expertise", null);

        tab.addTab(personMenteesTab, "Mentees", null);

        tab.addTab(personFileUploadsTabs, "Person Files Upload", null);

        switch (selectedTab) {
            case "LANDING":
                tab.setSelectedTab(contactTab);
                break;
            case "COURSES":
                tab.setSelectedTab(personCoursesTab);
                break;
            case "MENTORING":
                tab.setSelectedTab(personMentoringTab);
                break;
            case "EDUCATION":
                tab.setSelectedTab(personEducationTab);
                break;
            case "IDS":
                tab.setSelectedTab(personIdetitiesTab);
                break;
            case "POSITIONS":
                tab.setSelectedTab(persoPositionTab);
                break;
            case "PROFF":
                tab.setSelectedTab(personregistrationsTab);
                break;
            case "ROLES":
                tab.setSelectedTab(personRolesTab);
                break;
            case "MENTEES":
                tab.setSelectedTab(personMenteesTab);
                break;
            case "EXPERT":
                tab.setSelectedTab(personExpertiseTab);
                break;
            case "PLANS":
                tab.setSelectedTab(actionPlansTab);
                break;

            case "UPLOADS":
                tab.setSelectedTab(personFileUploadsTabs);
                break;

        }

        addComponent(tab);

    }
}
