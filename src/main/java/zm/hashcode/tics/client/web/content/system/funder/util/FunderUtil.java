/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.funder.util;

import zm.hashcode.tics.client.web.content.system.funder.model.FunderBean;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.util.Funder;

/**
 *
 * @author geek
 */
public class FunderUtil {

    public FunderBean getBean(Funder funder) {
        FunderBean bean = new FunderBean();
        bean.setId(funder.getId());
        bean.setContactNumber(funder.getContact().getContactNumber());
        bean.setEmailAddress(funder.getContact().getEmailAddress());
        bean.setPhysicalAddress(funder.getContact().getPostalAddress());
        bean.setPostalAddress(funder.getContact().getPostalAddress());
        bean.setPostalCode(funder.getContact().getPostalCode());
//
        bean.setLocationId(getCity(funder.getCity()));
//
        bean.setTrainingFunderName(funder.getTrainingFunderName());
        bean.setCourseCenter(funder.getCourseCenter());
        return bean;
    }

    public String getCity(Location location) {
        return location.getId();
    }
}
