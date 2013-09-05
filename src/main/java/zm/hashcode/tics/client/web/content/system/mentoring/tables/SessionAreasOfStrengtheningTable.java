/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.training.mentoring.SessionAreasOfStrengtheningFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;

/**
 *
 * @author geek
 */
public class SessionAreasOfStrengtheningTable extends Table {

    private final TicsMain main;

    public SessionAreasOfStrengtheningTable(TicsMain main) {
        this.main = main;
        setSizeFull();

        addContainerProperty("Areas Of Strengthening", String.class, null);

        List<SessionAreasOfStrengthening> areasOfStrengthenings = SessionAreasOfStrengtheningFacade.getSessionAreasOfStrengtheningService().findAll();
        for (SessionAreasOfStrengthening areasOfStrengthening : areasOfStrengthenings) {
            addItem(new Object[]{areasOfStrengthening.getAreasOfStrengthening()
            }, areasOfStrengthening.getId());
        }
        //     Allow selecting items from the table.

        setNullSelectionAllowed(false);
        //
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
