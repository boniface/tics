/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.course.util;

import zm.hashcode.tics.client.web.content.training.course.model.CourseTypeBean;
import zm.hashcode.tics.client.web.content.training.course.model.CriteriaBean;
import zm.hashcode.tics.domain.training.course.CourseType;
import zm.hashcode.tics.domain.training.course.Criteria;

/**
 *
 * @author geek
 */
public class CriteriaUtil {

    public CriteriaBean getBean(Criteria criteria) {
        CriteriaBean bean = new CriteriaBean();
        bean.setId(criteria.getId());
        bean.setName(criteria.getName());
        return bean;
    }
}
