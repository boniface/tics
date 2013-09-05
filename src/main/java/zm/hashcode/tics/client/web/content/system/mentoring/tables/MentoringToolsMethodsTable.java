/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.MentoringToolsMethodsFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;

/**
 *
 * @author geek
 */
public class MentoringToolsMethodsTable extends Table {

    private final TicsMain main;

    public MentoringToolsMethodsTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Tools Method", String.class, null);

        List<MentoringToolsMethods> mentoringToolsMethods = MentoringToolsMethodsFacade.getMentoringToolsMethodsService().findAll();
        for (MentoringToolsMethods mentoringToolsMethod : mentoringToolsMethods) {
            addItem(new Object[]{mentoringToolsMethod.getToolsMethod()
            }, mentoringToolsMethod.getId());
        }
        //     Allow selecting items from the table.

        setNullSelectionAllowed(false);
        //
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
