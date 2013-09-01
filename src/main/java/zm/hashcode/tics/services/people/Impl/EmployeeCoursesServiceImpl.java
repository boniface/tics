/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.EmployeeCourses;
import zm.hashcode.tics.repository.people.EmployeeCoursesRepository;
import zm.hashcode.tics.services.people.EmployeeCoursesService;

/**
 *
 * @author geek
 */
@Service
public class EmployeeCoursesServiceImpl implements EmployeeCoursesService {

    @Autowired
    private EmployeeCoursesRepository employeeCoursesRepository;

    @Override
    public EmployeeCourses find(String id) {
        return employeeCoursesRepository.findOne(id);
    }

    @Override
    public EmployeeCourses persist(EmployeeCourses entity) {
        return employeeCoursesRepository.save(entity);
    }

    @Override
    public EmployeeCourses merge(EmployeeCourses entity) {
        return employeeCoursesRepository.save(entity);
    }

    @Override
    public void remove(EmployeeCourses entity) {
        employeeCoursesRepository.delete(entity);
    }

    @Override
    public List<EmployeeCourses> findAll() {
        return ImmutableList.copyOf(employeeCoursesRepository.findAll());
    }
}
