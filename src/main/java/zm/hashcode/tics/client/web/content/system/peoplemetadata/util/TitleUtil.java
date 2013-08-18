/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.TitleBean;
import zm.hashcode.tics.domain.ui.demographics.Title;

/**
 *
 * @author geek
 */
public class TitleUtil {

    public TitleBean getBean(Title title) {
        TitleBean bean = new TitleBean();
        bean.setId(title.getId());
        bean.setTitle(title.getTitle());
        return bean;
    }
}
