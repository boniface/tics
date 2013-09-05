/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.mentoring.util;

import zm.hashcode.tics.client.web.content.system.mentoring.model.MentoringThemeBean;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;

/**
 *
 * @author geek
 */
public class MentoringThemeUtil {

    public MentoringThemeBean getBean(MentoringTheme entity) {
        MentoringThemeBean bean = new MentoringThemeBean();
        bean.setId(entity.getId());
        bean.setMentoringTheme(entity.getMentoringTheme());
        bean.setMentoringFieldId(entity.getMentoringField().getId());
        return bean;
    }
}
