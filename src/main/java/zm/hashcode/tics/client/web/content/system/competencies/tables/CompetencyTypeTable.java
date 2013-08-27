/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.competencies.CompetencyTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author geek
 */
public class CompetencyTypeTable extends Table {

    private final TicsMain main;

    public CompetencyTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Competency Type Name", String.class, null);
        List<CompetencyType> competencyTypes = CompetencyTypeFacade.getCompetencyTypeService().findAll();
        for (CompetencyType iCompetencyType : competencyTypes) {
            addItem(new Object[]{iCompetencyType.getName()
            }, iCompetencyType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
