/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.reports.util;

import com.google.common.collect.Collections2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.services.people.predicates.FemalePredicate;

/**
 *
 * @author boniface
 */
public class PeopleData implements Serializable {

    public List<PeopleReport> getReportData(ReportQuery query) {

        System.out.println(" The Query For facility is  " + query.getFacilityId());
        System.out.println(" The Query  For Location Type is  " + query.getLocationTypeId());
        System.out.println(" The Query For Location is  " + query.getLocationId());

        System.out.println(" The Query For Prefessional is  " + query.getProfessionId());
        System.out.println(" The Query For Competrency is  " + query.getCourseId());

        List<Person> people = PersonFacade.getPeople();
        Collection<Person> filteredResuluts = Collections2.filter(people, new FemalePredicate());
        List<PeopleReport> data = getPeopleData(filteredResuluts);
        return data;


    }

    private List<PeopleReport> getPeopleData(Collection<Person> filteredResuluts) {
        List<PeopleReport> pr = new ArrayList<>();
        for (Person person : filteredResuluts) {
            PeopleReport r = new PeopleReport();


            r.setId(person.getId());
            r.setFirstname(person.getFirstname());
            r.setLastname(person.getSurname());
            r.setProfession(person.getCurrentPosition());
//
//            r.setCourseName(null);
//            r.setCourseStateDate(null);
//            r.setCourseEndDate(null);
            r.setFacilityname(getFacilityName(person.getFacility()));
//            r.setDistrict(getDistrict(person.getFacility()));
            r.setSubdistrict(getSubDistrict(person.getFacility()));
            r.setCityname(getCityName(person.getFacility()));
            pr.add(r);

        }

        return pr;
    }

    private String getFacilityName(Facility facility) {
        if (facility != null) {
            return facility.getFacilityName();
        }
        return null;
    }

    private String getDistrict(Facility facility) {
        if (facility != null) {
            return facility.getCity().getParent().getParent().getName();
        }
        return null;
    }

    private String getSubDistrict(Facility facility) {
        if (facility != null) {
            return getParentCity(facility.getCity());
        }
        return null;
    }

    private String getCityName(Facility facility) {
        if (facility != null) {
            return getLocationName(facility.getCity());
        }
        return null;
    }

    private String getParentCity(Location city) {
        if (city != null) {
            return getLocationName(city.getParent());
        }
        return null;
    }

    private String getLocationName(Location location) {
        if (location != null) {
            return location.getName();
        }
        return null;

    }
}
