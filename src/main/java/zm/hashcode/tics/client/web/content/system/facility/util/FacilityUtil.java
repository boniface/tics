/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.FacilityBean;
import zm.hashcode.tics.domain.offices.Facility;

/**
 *
 * @author boniface
 */
public class FacilityUtil {

    public FacilityBean getBean(Facility facility) {
        FacilityBean bean = new FacilityBean();
        bean.setId(facility.getId());
        bean.setFacilityName(facility.getFacilityName());
        return bean;
    }
}
