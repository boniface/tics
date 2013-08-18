/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.TitleFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author geek
 */
public class TitleTable extends Table {

    private final TicsMain main;

    public TitleTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Title", String.class, null);
        List<Title> titles = TitleFacade.getTitleService().findAll();
        for (Title iTitle : titles) {
            addItem(new Object[]{iTitle.getTitle()
            }, iTitle.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
