/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.course.Course;
import zm.hashcode.tics.repository.training.course.CourseRepository;
import zm.hashcode.tics.services.training.course.CourseService;

/**
 *
 * @author geek
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course find(String id) {
        return courseRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = "courses", allEntries = true)
    public Course persist(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "courses", allEntries = true)
    public Course merge(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "courses", allEntries = true)
    public void remove(Course entity) {
        courseRepository.delete(entity);
    }

    @Override
    @Cacheable("courses")
    public List<Course> findAll() {
        return ImmutableList.copyOf(courseRepository.findAll());
    }
}
