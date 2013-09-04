/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringObjectiveFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;

/**
 *
 * @author geek
 */
public class MentoringObjectiveTable extends Table {

    private final TicsMain main;

    public MentoringObjectiveTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Mentoring Objective;", String.class, null);

        List<MentoringObjective> mentoringObjectives = MentoringObjectiveFacade.getMentoringObjectiveService().findAll();
        for (MentoringObjective mentoringObjective : mentoringObjectives) {
            addItem(new Object[]{mentoringObjective.getMentoringObjective()
            }, mentoringObjective.getId());
        }
        //     Allow selecting items from the table.

        setNullSelectionAllowed(false);
        //
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
