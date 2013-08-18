/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.LanguageBean;
import zm.hashcode.tics.domain.ui.demographics.Language;

/**
 *
 * @author geek
 */
public class LanguageUtil {

    public LanguageBean getBean(Language language) {
        LanguageBean bean = new LanguageBean();
        bean.setId(language.getId());
        bean.setName(language.getName());
        return bean;
    }
}
