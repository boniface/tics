/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.util;

import zm.hashcode.tics.client.web.content.training.institutions.model.CourseTypeBean;
import zm.hashcode.tics.domain.training.course.CourseType;

/**
 *
 * @author geek
 */
public class CourseTypeUtil {

    public CourseTypeBean getBean(CourseType courseType) {
        CourseTypeBean bean = new CourseTypeBean();
        bean.setId(courseType.getId());
        bean.setName(courseType.getName());
        return bean;
    }
}
