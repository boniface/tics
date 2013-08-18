/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.ui.demographics.IdentificationTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;

/**
 *
 * @author geek
 */
public class IdentificationTypeTable extends Table {

    private final TicsMain main;

    public IdentificationTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Id Value", String.class, null);
        addContainerProperty("Description", String.class, null);
        List<IdentificationType> identificationTypes = IdentificationTypeFacade.getIdentificationTypeService().findAll();
        for (IdentificationType iIdentificationType : identificationTypes) {
            addItem(new Object[]{iIdentificationType.getIdvalue(),
                iIdentificationType.getDescription()
            }, iIdentificationType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
//id;
//    private String idvalue;
//    private String description;

