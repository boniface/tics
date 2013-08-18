/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.GenderFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.Gender;

/**
 *
 * @author geek
 */
public class GenderTable extends Table {

    private final TicsMain main;

    public GenderTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Gender", String.class, null);
        List<Gender> genders = GenderFacade.getGenderService().findAll();
        for (Gender iGender : genders) {
            addItem(new Object[]{iGender.getGender()
            }, iGender.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
