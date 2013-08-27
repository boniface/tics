/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.util;

import java.util.List;
import zm.hashcode.tics.client.web.content.people.admin.model.PersonBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author boniface
 */
public class PersonUtil {

    public PersonBean getBean(Person person) {
        PersonBean bean = new PersonBean();
        bean.setId(person.getId());
        bean.setFirstname(person.getFirstname());
        bean.setOthername(person.getOthername());

        List<PersonIdentities> ids = person.getIdentities();
        PersonIdentities pid = ids.get(0);
        bean.setIdentitiesId(getIdentityType(pid));
        bean.setIdValue(getIdentitityValue(pid));

        bean.setFacilityId(getFacilityId(person.getFacility()));
        bean.setTitleId(getTitleId(person.getTitle()));
        bean.setGenderId(getGender(person.getDemography()));
        bean.setRaceId(getRace(person.getDemography()));


        return bean;
    }

    private String getIdentityType(PersonIdentities pid) {
        if (pid != null) {
            return getIdId(pid.getIdType());
        }
        return null;
    }

    private String getIdId(IdentificationType idType) {
        if (idType != null) {
            return idType.getId();
        }
        return null;
    }

    private String getIdentitityValue(PersonIdentities pid) {
        if (pid != null) {
            return pid.getIdValue();
        }
        return null;
    }

    private String getFacilityId(Facility facility) {
        if (facility != null) {
            return facility.getId();
        }
        return null;
    }

    private String getTitleId(Title title) {
        if (title != null) {
            return title.getId();
        }
        return null;
    }

    private String getGender(Demography demography) {
        if (demography != null) {
            return getGenderId(demography.getGender());
        }
        return null;
    }

    private String getRace(Demography demography) {
        if (demography != null) {
            return getRaceId(demography.getRace());
        }
        return null;
    }

    private String getGenderId(Gender gender) {
        if (gender != null) {
            return gender.getId();
        }
        return null;
    }

    private String getRaceId(Race race) {
        if (race != null) {
            return race.getId();
        }
        return null;
    }
}
