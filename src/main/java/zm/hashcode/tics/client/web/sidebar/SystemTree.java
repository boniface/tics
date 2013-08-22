/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.sidebar;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Tree;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.competencies.CompetenciesMenu;
import zm.hashcode.tics.client.web.content.system.facility.FacilityMenu;
import zm.hashcode.tics.client.web.content.system.funder.FunderMenu;
import zm.hashcode.tics.client.web.content.system.locations.LocationsMenu;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.PeopleMetaDataMenu;
import zm.hashcode.tics.client.web.content.system.positions.PositionsMenu;
import zm.hashcode.tics.client.web.content.system.traininginstitution.TrainingInstitutionsMenu;

/**
 *
 * @author boniface
 */
public class SystemTree extends Tree implements ItemClickEvent.ItemClickListener {

    private final TicsMain main;
    public static final Object GEOGRAPHICAL_LOCATIONS = "Geogrphical LOCATIONS";
    public static final Object PEOPLE_META_DATA = "People META DATA";
    public static final Object FACILITY_SETUP = "Facility SETUP";
    public static final Object TRAINING_INSTITUTIONS = "Training INSTITUTIONS";
    public static final Object POSITIONS_SETUP = "Positions SETUP";
    public static final Object CONPETENCIES_SETUP = "Competancies SETUP";
    public static final Object FUNDER_SETUP = "Funder SETUP";
    private static final String LANDING_TAB = "LANDING";

    public SystemTree(TicsMain main) {
        this.main = main;
        addItem(GEOGRAPHICAL_LOCATIONS);
        addItem(PEOPLE_META_DATA);
        addItem(FACILITY_SETUP);
        addItem(TRAINING_INSTITUTIONS);
        addItem(POSITIONS_SETUP);
        addItem(CONPETENCIES_SETUP);
        addItem(FUNDER_SETUP);

        //Add Listeners
        addItemClickListener((ItemClickEvent.ItemClickListener) this);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (itemId != null) {
            if (GEOGRAPHICAL_LOCATIONS.equals(itemId)) {
                geogrphicalView();
            } else if (PEOPLE_META_DATA.equals(itemId)) {
                peoplemetadataView();
            } else if (FACILITY_SETUP.equals(itemId)) {
                facilityView();
            } else if (TRAINING_INSTITUTIONS.equals(itemId)) {
                trainingInstitutionView();
            } else if (POSITIONS_SETUP.equals(itemId)) {
                positionInstitutionmView();
            } else if (CONPETENCIES_SETUP.equals(itemId)) {
                competenciesView();
            } else if (FUNDER_SETUP.equals(itemId)) {
                funderView();
            }
        }
    }

    private void geogrphicalView() {
        main.content.setSecondComponent(new LocationsMenu(main, LANDING_TAB));
    }

    private void peoplemetadataView() {
        main.content.setSecondComponent(new PeopleMetaDataMenu(main, LANDING_TAB));
    }

    private void facilityView() {
        main.content.setSecondComponent(new FacilityMenu(main, LANDING_TAB));
    }

    private void trainingInstitutionView() {
        main.content.setSecondComponent(new TrainingInstitutionsMenu(main, LANDING_TAB));
    }

    private void positionInstitutionmView() {
        main.content.setSecondComponent(new PositionsMenu(main, LANDING_TAB));
    }

    private void competenciesView() {
        main.content.setSecondComponent(new CompetenciesMenu(main, LANDING_TAB));
    }

    private void funderView() {
        main.content.setSecondComponent(new FunderMenu(main, LANDING_TAB));
    }
}
