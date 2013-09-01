/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.EmployeeMentoring;
import zm.hashcode.tics.repository.people.EmployeeMentoringRepository;
import zm.hashcode.tics.services.people.EmployeeMentoringService;

/**
 *
 * @author geek
 */
@Service
public class EmployeeMentoringServiceImpl implements EmployeeMentoringService {

    @Autowired
    private EmployeeMentoringRepository employeeMentoringRepository;

    @Override
    public EmployeeMentoring find(String id) {
        return employeeMentoringRepository.findOne(id);
    }

    @Override
    public EmployeeMentoring persist(EmployeeMentoring entity) {
        return employeeMentoringRepository.save(entity);
    }

    @Override
    public EmployeeMentoring merge(EmployeeMentoring entity) {
        return employeeMentoringRepository.save(entity);
    }

    @Override
    public void remove(EmployeeMentoring entity) {
        employeeMentoringRepository.delete(entity);
    }

    @Override
    public List<EmployeeMentoring> findAll() {
        return ImmutableList.copyOf(employeeMentoringRepository.findAll());
    }
}
