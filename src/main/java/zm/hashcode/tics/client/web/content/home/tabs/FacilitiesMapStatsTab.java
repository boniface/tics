/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home.tabs;

import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.GoogleMapMarker;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import zm.hashcode.tics.app.facade.offices.FacilityFacade;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Facility;

/**
 *
 * @author boniface
 */
public class FacilitiesMapStatsTab extends VerticalLayout {

    private final TicsMain main;
    private final GoogleMap googleMap;
    private final String apiKey = "";

    public FacilitiesMapStatsTab(TicsMain main) {
        this.main = main;
        setSizeFull();
        VerticalLayout map = new VerticalLayout();
        map.setSizeFull();
        map.setCaption("MAP");
        googleMap = new GoogleMap(new LatLon(-31.184609, 27.682114), 10.0, apiKey);
        googleMap.setSizeFull();
        List<Facility> facilities = FacilityFacade.getFacilityService().findAll();

        for (Facility facility : facilities) {
            if (facility.getLatitude() != null && facility.getLongititude() != null) {
                GoogleMapMarker marker = new GoogleMapMarker(facility.getFacilityName(), new LatLon(getValue(facility.getLatitude()), getValue(facility.getLongititude())), false);
                googleMap.addMarker(marker);

            }

        }


        map.addComponent(googleMap);
        map.setSizeFull();
        Panel p = new Panel();
        p.setContent(googleMap);
        p.setHeight("800px");
        addComponent(p);
    }

    private double getValue(String latlon) {

        double value = 0;
        try {
            value = Double.parseDouble(latlon);
        } catch (NumberFormatException numberFormatException) {
        }

        return value;
    }
}
