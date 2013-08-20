/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.util;

import zm.hashcode.tics.client.web.content.system.positions.model.DepartureReasonBean;
import zm.hashcode.tics.domain.ui.position.DepartureReason;

/**
 *
 * @author geek
 */
public class DepartureReasonUtil {

    public DepartureReasonBean getBean(DepartureReason DepartureReason) {
        DepartureReasonBean bean = new DepartureReasonBean();
        bean.setId(DepartureReason.getId());
        bean.setId(DepartureReason.getId());
        bean.setDescription(DepartureReason.getDescription());
        bean.setReasonName(DepartureReason.getReasonName());
        return bean;
    }
}
