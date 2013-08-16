/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.FacilityTypeBean;
import zm.hashcode.tics.domain.offices.FacilityType;

/**
 *
 * @author boniface
 */
public class FacilityUtil {

    public FacilityTypeBean getBean(FacilityType facilityType) {
        FacilityTypeBean bean = new FacilityTypeBean();
        bean.setId(facilityType.getId());
        bean.setFacilityName(facilityType.getFacilityName());
        return bean;
    }
}
