/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.util;

import zm.hashcode.tics.client.web.content.system.competencies.model.CompetencyBean;
import zm.hashcode.tics.domain.training.competencies.Competency;

/**
 *
 * @author geek
 */
public class CompetencyUtil {

    public CompetencyBean getBean(Competency competency) {
        CompetencyBean bean = new CompetencyBean();
        bean.setId(competency.getId());
        bean.setName(competency.getName());
        bean.setNotes(competency.getNotes());
        bean.setCompetencyTypeId(competency.getType().getId());

        return bean;
    }
}
