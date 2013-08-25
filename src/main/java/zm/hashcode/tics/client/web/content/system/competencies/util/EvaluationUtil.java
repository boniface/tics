/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.competencies.util;

import zm.hashcode.tics.client.web.content.system.competencies.model.EvaluationBean;
import zm.hashcode.tics.domain.training.competencies.Evaluation;

/**
 *
 * @author geek
 */
public class EvaluationUtil {

    public EvaluationBean getBean(Evaluation evaluation) {
        EvaluationBean bean = new EvaluationBean();
        bean.setId(evaluation.getId());
        bean.setName(evaluation.getName());
        return bean;
    }
}
