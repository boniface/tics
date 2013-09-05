/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.SessionAreasOfStrengtheningBean;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;

/**
 *
 * @author geek
 */
public class SessionAreasOfStrengtheningUtil {

    public SessionAreasOfStrengtheningBean getBean(SessionAreasOfStrengthening entity) {
        SessionAreasOfStrengtheningBean bean = new SessionAreasOfStrengtheningBean();
        bean.setId(entity.getId());
        bean.setAreasOfStrengthening(entity.getAreasOfStrengthening());
        return bean;
    }
}
