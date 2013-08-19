/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.traininginstitution;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.traininginstitution.tabs.TrainingInstitutionTab;

/**
 *
 * @author boniface
 */
public class TrainingInstitutionsMenu extends Menu {

    public TrainingInstitutionsMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout trainingTab = new VerticalLayout();
        trainingTab.setMargin(true);
        trainingTab.addComponent(new TrainingInstitutionTab(getMain()));

        getTab().addTab(trainingTab, "Training INSTITUTION", null);
        
        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(trainingTab);
                break;
            
        }
        addComponent(getTab());

    }
}
