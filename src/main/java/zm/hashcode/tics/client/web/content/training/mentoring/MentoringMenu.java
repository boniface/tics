/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.mentoring;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.training.mentoring.tabs.EnrollMenteesTab;
import zm.hashcode.tics.client.web.content.training.mentoring.tabs.MentoringSessionTab;
import zm.hashcode.tics.client.web.content.training.mentoring.tabs.ReportMentoringTab;

/**
 *
 * @author boniface
 */
public class MentoringMenu extends Menu {

    public MentoringMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout creatingMentoringSession = new VerticalLayout();
        creatingMentoringSession.setMargin(true);
        creatingMentoringSession.addComponent(new MentoringSessionTab(getMain()));


        final VerticalLayout enrollMenteesTab = new VerticalLayout();
        enrollMenteesTab.setMargin(true);
        enrollMenteesTab.addComponent(new EnrollMenteesTab(getMain()));

        final VerticalLayout reportMentoringTab = new VerticalLayout();
        reportMentoringTab.setMargin(true);
        reportMentoringTab.addComponent(new ReportMentoringTab(getMain()));

        getTab().addTab(creatingMentoringSession, "Create Mentoring Session", null);
        getTab().addTab(enrollMenteesTab, "Enroll Mentoring Mentees", null);
        getTab().addTab(reportMentoringTab, "Report mentoring Session ", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(creatingMentoringSession);
                break;
            case "ENROLMENTEES":
                getTab().setSelectedTab(enrollMenteesTab);
                break;
            case "REPORTSESSION":
                getTab().setSelectedTab(reportMentoringTab);
                break;
        }
        addComponent(getTab());

    }
}
