/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.training.institutions.util;

import zm.hashcode.tics.client.web.content.training.institutions.model.ContactBean;
import zm.hashcode.tics.domain.ui.location.Contact;

/**
 *
 * @author geek
 */
public class ContactUtil {

    public ContactBean getBean(Contact contactList) {
        ContactBean bean = new ContactBean();
//        bean.setId(contactList.getId());
//        bean.setName(contactList.getName());
        return bean;
    }
}
