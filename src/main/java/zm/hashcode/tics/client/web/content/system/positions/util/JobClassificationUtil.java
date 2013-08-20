/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.util;

import zm.hashcode.tics.client.web.content.system.positions.model.JobClassificationBean;
import zm.hashcode.tics.domain.ui.job.JobClassification;

/**
 *
 * @author geek
 */
public class JobClassificationUtil {

    public JobClassificationBean getBean(JobClassification jobClassification) {
        JobClassificationBean bean = new JobClassificationBean();
        bean.setId(jobClassification.getId());
        bean.setCodeConversion(jobClassification.getCodeConversion());
        bean.setComment(jobClassification.getComment());
        bean.setCurrentCode(jobClassification.getCurrentCode());
        bean.setCurrentTitle(jobClassification.getCurrentTitle());
        bean.setOldCode(jobClassification.getOldCode());
        bean.setOldTitle(jobClassification.getOldTitle());
        return bean;
    }
}
