/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringFieldBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;

/**
 *
 * @author geek
 */
public class MentoringFieldUtil {

    public MentoringFieldBean getBean(MentoringField entity) {
        MentoringFieldBean bean = new MentoringFieldBean();
        bean.setId(entity.getId());
        bean.setFieldName(entity.getFieldName());
        return bean;
    }
}
