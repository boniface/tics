/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.competencies.EvaluationFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.competencies.Evaluation;

/**
 *
 * @author geek
 */
public class EvaluationTable extends Table {

    private final TicsMain main;

    public EvaluationTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        List<Evaluation> evaluations = EvaluationFacade.getEvaluationService().findAll();
        for (Evaluation iEvaluation : evaluations) {
            addItem(new Object[]{iEvaluation.getName()
            }, iEvaluation.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
