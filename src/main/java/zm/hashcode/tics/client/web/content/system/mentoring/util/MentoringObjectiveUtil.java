/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringObjectiveBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;

/**
 *
 * @author geek
 */
public class MentoringObjectiveUtil {

    public MentoringObjectiveBean getBean(MentoringObjective entity) {
        MentoringObjectiveBean bean = new MentoringObjectiveBean();
        bean.setId(entity.getId());
        bean.setMentoringObjective(entity.getMentoringObjective());
        return bean;
    }
}
