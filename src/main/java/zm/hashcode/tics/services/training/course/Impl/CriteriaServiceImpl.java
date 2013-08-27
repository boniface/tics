/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.course.Criteria;
import zm.hashcode.tics.repository.training.course.CriteriaRepository;
import zm.hashcode.tics.services.training.course.CriteriaService;

/**
 *
 * @author geek
 */
@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public Criteria find(String id) {
        return criteriaRepository.findOne(id);
    }

    @Override
    public Criteria persist(Criteria entity) {
        return criteriaRepository.save(entity);
    }

    @Override
    public Criteria merge(Criteria entity) {
        return criteriaRepository.save(entity);
    }

    @Override
    public void remove(Criteria entity) {
        criteriaRepository.delete(entity);
    }

    @Override
    public List<Criteria> findAll() {
        return ImmutableList.copyOf(criteriaRepository.findAll());
    }
}
