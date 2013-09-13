/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.home.tabs;

import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.GoogleMapMarker;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;

/**
 *
 * @author boniface
 */
public class FacilitiesStatsTab extends VerticalLayout {

    private final TicsMain main;
    private GoogleMap googleMap;
    private GoogleMapMarker kakolaMarker;
    private final String apiKey = "AIzaSyAmEPi9fulTtG2wTggSn9b-dbCfhtnJaaM";

    public FacilitiesStatsTab(TicsMain main) {
        setSizeFull();
        kakolaMarker = new GoogleMapMarker("DRAGGABLE: Kakolan vankila", new LatLon(60.44291, 22.242415), true);
        googleMap = new GoogleMap(new LatLon(60.440963, 22.25122), 10.0, apiKey);

        this.main = main;

        googleMap.setSizeFull();

        googleMap.addMarker(kakolaMarker);

        googleMap.setMinZoom(4.0);
        googleMap.setMaxZoom(16.0);

        addComponent(googleMap);


    }
}
