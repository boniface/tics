/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.util;

import zm.hashcode.tics.client.web.content.system.funder.model.StatusBean;
import zm.hashcode.tics.domain.ui.util.Status;

/**
 *
 * @author geek
 */
public class StatusUtil {

    public StatusBean getBean(Status status) {
        StatusBean bean = new StatusBean();
        bean.setId(status.getId());
        bean.setStatusType(status.getStatusType());
        bean.setStatusValue(status.getStatusValue());
        return bean;
    }
}
