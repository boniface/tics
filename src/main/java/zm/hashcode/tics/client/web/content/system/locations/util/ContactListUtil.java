/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.locations.util;

import zm.hashcode.tics.client.web.content.system.locations.model.ContactListBean;
import zm.hashcode.tics.domain.ui.location.Contact;

/**
 *
 * @author geek
 */
public class ContactListUtil {

    public ContactListBean getBean(Contact contactList) {
        ContactListBean bean = new ContactListBean();
        bean.setId(contactList.getId());
        bean.setName(contactList.getName());
        return bean;
    }
}
