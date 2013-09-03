/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstitutionFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;

/**
 *
 * @author geek
 */
public class TrainingInstitutionTable extends Table {

    private final TicsMain main;

    public TrainingInstitutionTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Training Institution", String.class, null);

        List<TrainingInstitution> trainingInstitutionList = TrainingInstitutionFacade.getTrainingInstitutionService().findAll();
        for (TrainingInstitution iTrainingInstitution : trainingInstitutionList) {
            addItem(new Object[]{iTrainingInstitution.getName()
            }, iTrainingInstitution.getId());
        }
//     Allow selecting items from the table.

        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }
}
