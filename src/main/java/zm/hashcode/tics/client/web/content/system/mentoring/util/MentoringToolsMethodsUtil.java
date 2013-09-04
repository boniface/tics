/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringToolsMethodsBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;

/**
 *
 * @author geek
 */
public class MentoringToolsMethodsUtil {

    public MentoringToolsMethodsBean getBean(MentoringToolsMethods entity) {
        MentoringToolsMethodsBean bean = new MentoringToolsMethodsBean();
        bean.setId(entity.getId());
        bean.setToolsMethod(entity.getToolsMethod());
        return bean;
    }
}
