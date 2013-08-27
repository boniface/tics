/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.competencies.CompetencyFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.competencies.Competency;

/**
 *
 * @author geek
 */
public class CompetencyTable extends Table {

    private final TicsMain main;

    public CompetencyTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Competency Name", String.class, null);
        addContainerProperty("Notes", String.class, null);
        List<Competency> competencies = CompetencyFacade.getCompetencyService().findAll();
        for (Competency iCompetency : competencies) {
            addItem(new Object[]{iCompetency.getName(),
                iCompetency.getNotes()
            }, iCompetency.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
