/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.job.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.job.Job;
import zm.hashcode.tics.repository.ui.job.JobRepository;
import zm.hashcode.tics.services.ui.job.JobService;

/**
 *
 * @author geek
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job find(String id) {
        return jobRepository.findOne(id);
    }

    @Override
    public Job persist(Job entity) {
        return jobRepository.save(entity);
    }

    @Override
    public Job merge(Job entity) {
        return jobRepository.save(entity);
    }

    @Override
    public void remove(Job entity) {
        jobRepository.delete(entity);
    }

    @Override
    public List<Job> findAll() {
        return ImmutableList.copyOf(jobRepository.findAll());
    }
}
