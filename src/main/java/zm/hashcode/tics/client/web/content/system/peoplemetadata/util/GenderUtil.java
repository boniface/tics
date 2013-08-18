/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.GenderBean;
import zm.hashcode.tics.domain.ui.demographics.Gender;

/**
 *
 * @author geek
 */
public class GenderUtil {

    public GenderBean getBean(Gender gender) {
        GenderBean bean = new GenderBean();
        bean.setId(gender.getId());
        bean.setGender(gender.getGender());
        return bean;
    }
}
