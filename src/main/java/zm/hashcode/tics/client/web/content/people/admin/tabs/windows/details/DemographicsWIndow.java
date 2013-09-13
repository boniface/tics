/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import java.util.List;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.Title;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author boniface
 */
public class DemographicsWIndow extends GridLayout {

    private final TicsMain main;

    public DemographicsWIndow(TicsMain main, Person person) {
        this.main = main;
        setColumns(7);
        setRows(4);
        setSizeFull();

//        //image
        addComponent(new Label("PICTURE HERE:"), 0, 0, 0, 2);
//
//        //titles
        addComponent(new Label("First Name: "), 1, 0);
        addComponent(new Label("Last Name: "), 1, 1);
        addComponent(new Label("Other Name: "), 1, 2);
//        //values
        addComponent(new Label(person.getFirstname()), 2, 0);
        addComponent(new Label(person.getSurname()), 2, 1);
        addComponent(new Label(person.getOthername()), 2, 2);
//
//         //titles
        addComponent(new Label("Title: "), 3, 0);
        addComponent(new Label("ID : "), 3, 1);
        addComponent(new Label("Gender: "), 3, 2);
//        //values
        addComponent(new Label(getTitle(person.getTitle())), 4, 0);
        addComponent(new Label(getIdentity(person.getIdentities())), 4, 1);
        addComponent(new Label(getGender(person.getDemography())), 4, 2);
//
//
//         //titles
        addComponent(new Label("Facility: "), 5, 0);
        addComponent(new Label("Residence: "), 5, 1);
        addComponent(new Label("Race: "), 5, 2);
//        //values
        addComponent(new Label(getFacility(person.getFacility())), 6, 0);
        addComponent(new Label(getResidence(person.getResidence())), 6, 1);
        addComponent(new Label(getRace(person.getDemography())), 6, 2);
//
    }

    private String getTitle(Title title) {
        if (title != null) {
            return title.getTitle();
        }
        return null;
    }

    private String getIdentity(List<PersonIdentities> identities) {
        if (!identities.isEmpty()) {
            PersonIdentities pid = identities.get(0);
            return pid.getIdValue();
        }
        return null;
    }

    private String getGender(Demography demography) {
        if (demography != null) {
            return demography.getGender().getGender();
        }
        return null;
    }

    private String getFacility(Facility facility) {
        if (facility != null) {
            return facility.getFacilityName();
        }
        return null;
    }

    private String getResidence(Location residence) {
        if (residence != null) {
            return residence.getName();
        }
        return null;
    }

    private String getRace(Demography demography) {
        if (demography != null) {
            return demography.getRace().getRaceName();
        }
        return null;
    }
}
