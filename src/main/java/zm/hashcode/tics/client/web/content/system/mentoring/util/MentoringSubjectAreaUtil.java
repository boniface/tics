/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringSubjectAreaBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;

/**
 *
 * @author geek
 */
public class MentoringSubjectAreaUtil {

    public MentoringSubjectAreaBean getBean(MentoringSubjectArea entity) {
        MentoringSubjectAreaBean bean = new MentoringSubjectAreaBean();
        bean.setId(entity.getId());
        bean.setSubjectArea(entity.getSubjectArea());
        return bean;
    }
}
