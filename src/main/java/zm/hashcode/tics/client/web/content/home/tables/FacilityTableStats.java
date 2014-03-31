/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home.tables;

import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;
import java.util.List;
import java.util.stream.Collectors;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.home.tabs.FacilitiesStatsTab;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
public class FacilityTableStats extends Table {

    private final TicsMain main;
    private final List<Person> people = PersonFacade.getPersonService().findAll();

    public FacilityTableStats(TicsMain main, List<Facility> facilities, final FacilitiesStatsTab tab) {
        this.main = main;

        setSizeFull();
        addContainerProperty("Name", String.class, null);
        addContainerProperty("District", String.class, null);
        addContainerProperty("Sub District", String.class, null);
        addContainerProperty("City/Town/Village", String.class, null);
        addContainerProperty("Health Worker Numbers", Integer.class, null);
        addContainerProperty("Details", Button.class, null);

        for (Facility facility : facilities) {

            Button detailsField = new Button("Show Details");
            detailsField.setData(facility.getId());
            detailsField.addClickListener((Button.ClickEvent event) -> {
                String itemId = (String) event.getButton().getData();
                Facility facility1 = FacilityFacade.getFacilityService().find(itemId);
                tab.contentPanel.removeAllComponents();
            });
            
            int workers = people.parallelStream().filter(f->facility.getFacilityName().equals(f.getFacility().getFacilityName())).collect(Collectors.toList()).size();
           
            
            detailsField.setStyleName(Reindeer.BUTTON_LINK);


            addItem(new Object[]{
                facility.getFacilityName(),
                getDistrict(facility.getCity()),
                getSubDistrict(facility.getCity()),
                getCity(facility.getCity()),
                workers,
                detailsField}, facility.getId());


        }
        // Allow selecting items from the table.
        setNullSelectionAllowed(false);
//
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);

    }

    private String getDistrict(Location city) {
        if (city != null) {
            return citySubDistrict(city.getParent());
        }
        return null;

    }

    private String getSubDistrict(Location city) {
        if (city != null) {
            return subDistrict(city.getParent());
        }
        return null;

    }

    private Object getCity(Location city) {
        if (city != null) {
            return city.getName();
        }
        return null;
    }

    private String subDistrict(Location parent) {
        if (parent != null) {
            return parent.getName();
        }
        return null;
    }

    private String citySubDistrict(Location parent) {
        if (parent != null) {
            return districtName(parent.getParent());
        }
        return null;
    }

    private String districtName(Location parent) {
        if (parent != null) {
            return parent.getName();
        }
        return null;
    }
}
