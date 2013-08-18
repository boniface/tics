/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.RaceFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.Race;

/**
 *
 * @author geek
 */
public class RaceTable extends Table {

    private final TicsMain main;

    public RaceTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Race Name", String.class, null);
        List<Race> races = RaceFacade.getRaceService().findAll();
        for (Race iRace : races) {
            addItem(new Object[]{iRace.getRaceName()
            }, iRace.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
