/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.job.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.job.JobClassification;
import zm.hashcode.tics.repository.ui.job.JobClassificationRepository;
import zm.hashcode.tics.services.ui.job.JobClassificationService;

/**
 *
 * @author geek
 */
@Service
public class JobClassificationServiceImpl implements JobClassificationService {

    @Autowired
    private JobClassificationRepository jobClassificationRepository;

    @Override
    public JobClassification find(String id) {
        return jobClassificationRepository.findOne(id);
    }

    @Override
    public JobClassification persist(JobClassification entity) {
        return jobClassificationRepository.save(entity);
    }

    @Override
    public JobClassification merge(JobClassification entity) {
        return jobClassificationRepository.save(entity);
    }

    @Override
    public void remove(JobClassification entity) {
        jobClassificationRepository.delete(entity);
    }

    @Override
    public List<JobClassification> findAll() {
        return ImmutableList.copyOf(jobClassificationRepository.findAll());
    }
}
