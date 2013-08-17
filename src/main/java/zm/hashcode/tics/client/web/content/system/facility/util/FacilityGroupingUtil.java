/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.FacilityGroupingBean;
import zm.hashcode.tics.domain.offices.FacilityGrouping;

/**
 *
 * @author geek
 */
public class FacilityGroupingUtil {

    public FacilityGroupingBean getBean(FacilityGrouping facilityGrouping) {
        FacilityGroupingBean bean = new FacilityGroupingBean();
        bean.setId(facilityGrouping.getId());
        bean.setClusterId(facilityGrouping.getCluster().getId());
        bean.setNodeId(facilityGrouping.getNode().getId());
        return bean;
    }
}
