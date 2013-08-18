/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.facility.util;

import zm.hashcode.tics.client.web.content.system.facility.model.RegistrationBodyBean;
import zm.hashcode.tics.domain.people.RegistrationBody;

/**
 *
 * @author geek
 */
public class RegistrationBodyUtil {

    public RegistrationBodyBean getBean(RegistrationBody registrationBody) {
        RegistrationBodyBean bean = new RegistrationBodyBean();
        bean.setId(registrationBody.getId());
        bean.setActive(registrationBody.getActive());
        bean.setCoreActivity(registrationBody.getCoreActivity());
        bean.setDescription(registrationBody.getDescription());
        bean.setName(registrationBody.getName());
        bean.setStartDate(registrationBody.getStartDate());
        return bean;
    }
}
