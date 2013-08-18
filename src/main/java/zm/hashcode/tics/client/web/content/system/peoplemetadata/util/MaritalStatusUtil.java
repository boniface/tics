/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.MaritalStatusBean;
import zm.hashcode.tics.domain.ui.demographics.MaritalStatus;

/**
 *
 * @author geek
 */
public class MaritalStatusUtil {

    public MaritalStatusBean getBean(MaritalStatus maritalStatus) {
        MaritalStatusBean bean = new MaritalStatusBean();
        bean.setId(maritalStatus.getId());
        bean.setStatusName(maritalStatus.getStatusName());
        return bean;
    }
}
