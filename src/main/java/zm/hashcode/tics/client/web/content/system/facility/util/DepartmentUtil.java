/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.DepartmentBean;
import zm.hashcode.tics.domain.offices.Department;

/**
 *
 * @author geek
 */
public class DepartmentUtil {

    public DepartmentBean getBean(Department department) {
        DepartmentBean bean = new DepartmentBean();
        bean.setId(department.getId());
        bean.setName(department.getName());
        return bean;
    }
}
