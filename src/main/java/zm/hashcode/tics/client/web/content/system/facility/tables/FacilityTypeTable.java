/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityTypeFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.FacilityType;

/**
 *
 * @author ColinWa
 */
public class FacilityTypeTable extends Table {

    private final TicsMain main;

    public FacilityTypeTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Facility Name", String.class, null);
        List<FacilityType> facilityTypes = FacilityTypeFacade.getFacilityTypeService().findAll();
        for (FacilityType iFacilityType : facilityTypes) {
            addItem(new Object[]{iFacilityType.getFacilityName()
            }, iFacilityType.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
}
