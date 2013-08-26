/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.course.CourseType;
import zm.hashcode.tics.repository.training.course.CourseTypeRepository;
import zm.hashcode.tics.services.training.course.CourseTypeService;

/**
 *
 * @author geek
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public CourseType find(String id) {
        return courseTypeRepository.findOne(id);
    }

    @Override
    public CourseType persist(CourseType entity) {
        return courseTypeRepository.save(entity);
    }

    @Override
    public CourseType merge(CourseType entity) {
        return courseTypeRepository.save(entity);
    }

    @Override
    public void remove(CourseType entity) {
        courseTypeRepository.delete(entity);
    }

    @Override
    public List<CourseType> findAll() {
        return ImmutableList.copyOf(courseTypeRepository.findAll());
    }
}
