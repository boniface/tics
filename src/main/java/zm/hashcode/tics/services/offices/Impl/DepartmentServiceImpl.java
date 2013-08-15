/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.Department;
import zm.hashcode.tics.repository.offices.DepartmentRepository;
import zm.hashcode.tics.services.offices.DepartmentService;

/**
 *
 * @author ColinWa
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department find(String id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department persist(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public Department merge(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public void remove(Department entity) {
        departmentRepository.delete(entity);
    }

    @Override
    public List<Department> findAll() {
        return ImmutableList.copyOf(departmentRepository.findAll());
    }
}
