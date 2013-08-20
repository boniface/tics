/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.schedule.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.repository.training.schedule.ScheduledCourseRepository;
import zm.hashcode.tics.services.training.institutions.schedule.ScheduledCourseService;

/**
 *
 * @author geek
 */
@Service
public class ScheduledCourseServiceImpl implements ScheduledCourseService {

    @Autowired
    private ScheduledCourseRepository scheduledCoursebRepository;

    @Override
    public ScheduledCourse find(String id) {
        return scheduledCoursebRepository.findOne(id);
    }

    @Override
    public ScheduledCourse persist(ScheduledCourse entity) {
        return scheduledCoursebRepository.save(entity);
    }

    @Override
    public ScheduledCourse merge(ScheduledCourse entity) {
        return scheduledCoursebRepository.save(entity);
    }

    @Override
    public void remove(ScheduledCourse entity) {
        scheduledCoursebRepository.delete(entity);
    }

    @Override
    public List<ScheduledCourse> findAll() {
        return ImmutableList.copyOf(scheduledCoursebRepository.findAll());
    }
}
