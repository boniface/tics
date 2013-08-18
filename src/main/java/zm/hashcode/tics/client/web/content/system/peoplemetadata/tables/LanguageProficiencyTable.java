/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.LanguageProficiencyFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.LanguageProficiency;

/**
 *
 * @author geek
 */
public class LanguageProficiencyTable extends Table {

    private final TicsMain main;

    public LanguageProficiencyTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Proficiency", String.class, null);
        List<LanguageProficiency> languageProficiencys = LanguageProficiencyFacade.getLanguageProficiencyService().findAll();
        for (LanguageProficiency iLanguageProficiency : languageProficiencys) {
            addItem(new Object[]{iLanguageProficiency.getProficiency()
            }, iLanguageProficiency.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
