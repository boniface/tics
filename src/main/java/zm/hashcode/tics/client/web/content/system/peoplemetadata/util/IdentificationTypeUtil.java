/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.IdentificationTypeBean;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;

/**
 *
 * @author geek
 */
public class IdentificationTypeUtil {

    public IdentificationTypeBean getBean(IdentificationType identificationType) {
        IdentificationTypeBean bean = new IdentificationTypeBean();
        bean.setId(identificationType.getId());
        bean.setIdvalue(identificationType.getIdvalue());
        bean.setDescription(identificationType.getDescription());
        return bean;
    }
}
