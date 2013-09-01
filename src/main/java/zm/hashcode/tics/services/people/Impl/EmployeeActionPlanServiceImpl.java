/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.EmployeeActionPlan;
import zm.hashcode.tics.repository.people.EmployeeActionPlanRepository;
import zm.hashcode.tics.services.people.EmployeeActionPlanService;

/**
 *
 * @author geek
 */
@Service
public class EmployeeActionPlanServiceImpl implements EmployeeActionPlanService {

    @Autowired
    private EmployeeActionPlanRepository employeeActionPlanRepository;

    @Override
    public EmployeeActionPlan find(String id) {
        return employeeActionPlanRepository.findOne(id);
    }

    @Override
    public EmployeeActionPlan persist(EmployeeActionPlan entity) {
        return employeeActionPlanRepository.save(entity);
    }

    @Override
    public EmployeeActionPlan merge(EmployeeActionPlan entity) {
        return employeeActionPlanRepository.save(entity);
    }

    @Override
    public void remove(EmployeeActionPlan entity) {
        employeeActionPlanRepository.delete(entity);
    }

    @Override
    public List<EmployeeActionPlan> findAll() {
        return ImmutableList.copyOf(employeeActionPlanRepository.findAll());
    }
}
