/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.util;

import zm.hashcode.tics.client.web.content.training.institutions.model.ContactAddressBean;
import zm.hashcode.tics.domain.ui.location.Contact;

/**
 *
 * @author geek
 */
public class ContactAddressUtil {

    public ContactAddressBean getBean(Contact contactList) {
        ContactAddressBean bean = new ContactAddressBean();
//        bean.setId(contactList.getId());
//        bean.setName(contactList.getName());
        return bean;
    }
}
