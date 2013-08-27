/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.util;

import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.client.web.content.system.locations.model.LocationBean;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.domain.ui.location.LocationType;

/**
 *
 * @author geek
 */
public class LocationUtil {

    public LocationBean getBean(Location location) {
        LocationBean bean = new LocationBean();
        bean.setId(location.getId());
        bean.setName(location.getName());
        bean.setCode(location.getCode());
        bean.setLatitude(location.getLatitude());
        bean.setLongitude(location.getLongitude());
        bean.setLocationTypeId(getLocationTypeId(location.getLocationType()));
        bean.setChildrenIds(getLocationChildren(location.getChildren()));
        bean.setParentId(getLocationParent(location.getParent()));

        return bean;
    }

    private String getLocationTypeId(LocationType locationType) {
        if (locationType != null) {
            return locationType.getId();
        }
        return null;
    }

    private List<String> getLocationChildren(List<Location> children) {
        List<String> ids = new ArrayList<>();
        for (Location location : children) {
            ids.add(location.getId());

        }
        return ids;
    }

    private String getLocationParent(Location parent) {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
