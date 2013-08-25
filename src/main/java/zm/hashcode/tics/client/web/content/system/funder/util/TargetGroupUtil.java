/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.util;

import zm.hashcode.tics.client.web.content.system.funder.model.TargetGroupBean;
import zm.hashcode.tics.domain.training.course.TargetGroup;

/**
 *
 * @author geek
 */
public class TargetGroupUtil {

    public TargetGroupBean getBean(TargetGroup targetGroup) {
        TargetGroupBean bean = new TargetGroupBean();
        bean.setId(targetGroup.getId());
        bean.setName(targetGroup.getName());
        return bean;
    }
}
