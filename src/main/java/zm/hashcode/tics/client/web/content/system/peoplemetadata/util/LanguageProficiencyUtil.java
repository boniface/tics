/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata.util;

import zm.hashcode.tics.client.web.content.system.peoplemetadata.model.LanguageProficiencyBean;
import zm.hashcode.tics.domain.ui.demographics.LanguageProficiency;

/**
 *
 * @author geek
 */
public class LanguageProficiencyUtil {

    public LanguageProficiencyBean getBean(LanguageProficiency languageProficiency) {
        LanguageProficiencyBean bean = new LanguageProficiencyBean();
        bean.setId(languageProficiency.getId());
        bean.setProficiency(languageProficiency.getProficiency());
        return bean;
    }
}
