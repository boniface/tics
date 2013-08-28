/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.FacilityBean;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationAddress;

/**
 *
 * @author boniface
 */
public class FacilityUtil {

    public FacilityBean getBean(Facility facility) {
        FacilityBean bean = new FacilityBean();
        bean.setCityId(getCityId(facility.getCity()));
        bean.setContactNumber(getContactNumber(facility.getAddress()));
        bean.setEmailAddress(getEmailAddress(facility.getAddress()));
        bean.setFacilityGroupingId(getGroupingId(facility.getFacilityGrouping()));

        bean.setFacilityTypeId(getFacilityId(facility.getFacilityType()));

        bean.setPhysicalAddress(getPysucalAdd(facility.getAddress()));
        bean.setPostalAddress(getPostalAdd(facility.getAddress()));
        bean.setPostalCode(getPostalCode(facility.getAddress()));

        bean.setId(facility.getId());
        bean.setFacilityName(facility.getFacilityName());
        return bean;
    }

    private String getCityId(Location city) {
        if (city != null) {
            return city.getId();
        }
        return null;
    }

    private String getContactNumber(LocationAddress address) {
        if (address != null) {
            return address.getContactNumber();
        }
        return null;
    }

    private String getEmailAddress(LocationAddress address) {
        if (address != null) {
            return address.getContactNumber();
        }
        return null;
    }

    private String getGroupingId(FacilityGrouping facilityGrouping) {
        if (facilityGrouping != null) {
            return facilityGrouping.getId();
        }
        return null;
    }

    private String getFacilityId(FacilityType facilityType) {
        if (facilityType != null) {
            return facilityType.getId();
        }
        return null;

    }

    private String getPysucalAdd(LocationAddress address) {
        if (address != null) {
            return address.getPhysicalAddress();
        }
        return null;
    }

    private String getPostalAdd(LocationAddress address) {
        if (address != null) {
            return address.getPostalAddress();
        }
        return null;
    }

    private String getPostalCode(LocationAddress address) {
        if (address != null) {
            return address.getPostalCode();
        }
        return null;
    }
}
