/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.util;

import zm.hashcode.tics.client.web.content.system.competencies.model.CompetencyTypeBean;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;

/**
 *
 * @author geek
 */
public class CompetencyTypeUtil {

    public CompetencyTypeBean getBean(CompetencyType competencyType) {
        CompetencyTypeBean bean = new CompetencyTypeBean();
        bean.setId(competencyType.getId());
        bean.setName(competencyType.getName());

        return bean;
    }
}
