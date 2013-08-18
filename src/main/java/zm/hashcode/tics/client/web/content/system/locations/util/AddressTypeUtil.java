/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.util;

import zm.hashcode.tics.client.web.content.system.locations.model.AddressTypeBean;
import zm.hashcode.tics.domain.ui.location.AddressType;

/**
 *
 * @author geek
 */
public class AddressTypeUtil {

    public AddressTypeBean getBean(AddressType addressType) {
        AddressTypeBean bean = new AddressTypeBean();
        bean.setId(addressType.getId());
        bean.setAddressTypeName(addressType.getAddressTypeName());
        return bean;
    }
}
