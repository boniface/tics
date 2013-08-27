/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.institutions.TrainingInstructorsFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;

/**
 *
 * @author geek
 */
public class TrainingInstructorTable extends Table {

    private final TicsMain main;

    public TrainingInstructorTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("First Name", String.class, null);
        addContainerProperty("Last Name", String.class, null);
        addContainerProperty("Other Name", String.class, null);
        addContainerProperty("Qualification", String.class, null);
        addContainerProperty("Area Of Expertise", String.class, null);

        List<TrainingInstructors> trainingInstructorS = TrainingInstructorsFacade.getTrainingInstructorsService().findAll();
        for (TrainingInstructors iTrainingInstructor : trainingInstructorS) {
            addItem(new Object[]{iTrainingInstructor.getFirstName(),
                iTrainingInstructor.getLastName(),
                iTrainingInstructor.getOtherName(),
                iTrainingInstructor.getQualification(),
                iTrainingInstructor.getAreaOfexpertise()
            }, iTrainingInstructor.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
