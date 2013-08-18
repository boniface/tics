/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.util;

import zm.hashcode.tics.client.web.content.system.locations.model.LocationTypeBean;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationTypeUtil {

    public LocationTypeBean getBean(LocationType locationType) {
        LocationTypeBean bean = new LocationTypeBean();
        bean.setId(locationType.getId());
        bean.setCode(locationType.getCode());
        bean.setName(locationType.getName());

        return bean;
    }
}
