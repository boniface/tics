/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.competencies.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.competencies.Evaluation;
import zm.hashcode.tics.repository.training.competencies.EvaluationRepository;
import zm.hashcode.tics.services.training.competencies.EvaluationService;

/**
 *
 * @author geek
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public Evaluation find(String id) {
        return evaluationRepository.findOne(id);
    }

    @Override
    public Evaluation persist(Evaluation entity) {
        return evaluationRepository.save(entity);
    }

    @Override
    public Evaluation merge(Evaluation entity) {
        return evaluationRepository.save(entity);
    }

    @Override
    public void remove(Evaluation entity) {
        evaluationRepository.delete(entity);
    }

    @Override
    public List<Evaluation> findAll() {
        return ImmutableList.copyOf(evaluationRepository.findAll());
    }
}
