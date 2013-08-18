/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.util;

import zm.hashcode.tics.client.web.content.system.locations.model.LocationBean;
import zm.hashcode.tics.domain.ui.location.Location;

/**
 *
 * @author geek
 */
public class LocationUtil {

    public LocationBean getBean(Location location) {
        LocationBean bean = new LocationBean();
        bean.setId(location.getId());
        bean.setChildren(location.getChildren());
        bean.setCode(location.getCode());
        bean.setLatitude(location.getLatitude());
        bean.setLocationType(location.getLocationType());
        bean.setLongitude(location.getLongitude());
        bean.setName(location.getName());
        bean.setParent(location.getParent());
        return bean;
    }
}
