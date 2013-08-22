/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.positions.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import zm.hashcode.tics.client.web.content.system.positions.model.JobBean;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.domain.ui.job.JobClassification;
import zm.hashcode.tics.domain.ui.position.Position;

/**
 *
 * @author geek
 */
public class JobUtil {

    public JobBean getBean(Job job) {
        JobBean bean = new JobBean();
        bean.setId(job.getId());
        bean.setCode(job.getCode());
        bean.setJobClassificationId(getJobClassificationId(job.getJobClassification()));
        bean.setDescription(job.getDescription());

        bean.setTitle(job.getTitle());

        return bean;
    }

    public String getJobClassificationId(JobClassification jobClassification) {
        return jobClassification.getId();
    }

    public Set<String> getPositionIds(List<Position> positions) {
        Set<String> ids = new HashSet<>();
        for (Position iPosition : positions) {
            ids.add(iPosition.getId());
        }
        return ids;

    }
}
