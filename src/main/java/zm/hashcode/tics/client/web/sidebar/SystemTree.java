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
import zm.hashcode.tics.client.web.content.system.training.TrainingSetupMenu;
import zm.hashcode.tics.client.web.content.training.mentoring.MentoringMenu;

/**
 *
 * @author boniface
 */
public class SystemTree extends Tree implements ItemClickEvent.ItemClickListener {

    private final TicsMain main;
    public static final Object LOCATIONS_SETUP = "Locations SETUP";
    public static final Object PEOPLE_SETUP = "People SETUP";
    public static final Object FACILITY_SETUP = "Facility SETUP";
    public static final Object TRAINING_SETUP = "Training SETUP";
    public static final Object MENTORING_SETUP = "Mentoring SETUP";
    public static final Object POSITIONS_SETUP = "Positions SETUP";
    public static final Object CONPETENCIES_SETUP = "Competancies SETUP";
    public static final Object FUNDER_SETUP = "Funder SETUP";
    private static final String LANDING_TAB = "LANDING";

    public SystemTree(TicsMain main) {
        this.main = main;
        addItem(LOCATIONS_SETUP);
        addItem(PEOPLE_SETUP);
        addItem(FACILITY_SETUP);
        addItem(TRAINING_SETUP);
        addItem(MENTORING_SETUP);
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
            if (LOCATIONS_SETUP.equals(itemId)) {
                geogrphicalView();
            } else if (PEOPLE_SETUP.equals(itemId)) {
                peoplemetadataView();
            } else if (FACILITY_SETUP.equals(itemId)) {
                facilityView();
            } else if (TRAINING_SETUP.equals(itemId)) {
                trainingSetupView();
            } else if (POSITIONS_SETUP.equals(itemId)) {
                positionInstitutionmView();
            } else if (CONPETENCIES_SETUP.equals(itemId)) {
                competenciesView();
            } else if (FUNDER_SETUP.equals(itemId)) {
                funderView();
            } else if (MENTORING_SETUP.equals(itemId)) {
                mentoringSetupView();
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

    private void trainingSetupView() {
        main.content.setSecondComponent(new TrainingSetupMenu(main, LANDING_TAB));
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

    private void mentoringSetupView() {
        main.content.setSecondComponent(new MentoringMenu(main, LANDING_TAB));
    }
}
