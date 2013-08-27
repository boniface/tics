/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.tables;

import com.vaadin.ui.Table;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author ColinWa
 */
public class FacilityTable extends Table {

    private final TicsMain main;

    public FacilityTable(TicsMain main) {
        this.main = main;
        setSizeFull();
        addContainerProperty("Facility Name", String.class, null);
        addContainerProperty("Facility Type", String.class, null);
        addContainerProperty("Contact Number", String.class, null);
        addContainerProperty("Email Address", String.class, null);
        addContainerProperty("City", String.class, null);

        List<Facility> faclities = FacilityFacade.getFacilityService().findAll();
        for (Facility facility : faclities) {
            addItem(new Object[]{
                facility.getFacilityName(),
                getFacilityType(facility.getFacilityType()),
                getContactNumber(facility.getAddress()),
                getContactEmailAddress(facility.getAddress()),
                getCity(facility.getCity())
            }, facility.getId());
        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }

    private String getFacilityType(FacilityType facilityType) {
        if (facilityType != null) {
            return facilityType.getFacilityName();
        }
        return null;
    }

    private String getContactNumber(LocationAddress address) {
        if (address != null) {
            return address.getContactNumber();
        }
        return null;
    }

    private String getContactEmailAddress(LocationAddress address) {
        if (address != null) {
            return address.getEmailAddress();
        }
        return null;
    }

    private String getCity(Location city) {
        if (city != null) {
            return city.getName();
        }
        return null;
    }
}
