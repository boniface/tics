/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.LanguageFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.Language;

/**
 *
 * @author geek
 */
public class LanguageTable extends Table {

    private final TicsMain main;

    public LanguageTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Name", String.class, null);
        List<Language> languages = LanguageFacade.getLanguageService().findAll();
        for (Language iLanguage : languages) {
            addItem(new Object[]{iLanguage.getName()
            }, iLanguage.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
