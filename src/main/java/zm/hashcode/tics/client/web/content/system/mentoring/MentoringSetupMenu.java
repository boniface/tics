/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author boniface
 */
public class MentoringSetupMenu extends Menu {

    public MentoringSetupMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout trainingTab = new VerticalLayout();
        trainingTab.setMargin(true);
//        trainingTab.addComponent(new TrainingInstitutionTab(getMain()));

        getTab().addTab(trainingTab, "Training INSTITUTION", null);

        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(trainingTab);
                break;

        }
        addComponent(getTab());

    }
}
