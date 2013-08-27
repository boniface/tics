/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.competencies.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.competencies.Competency;
import zm.hashcode.tics.repository.training.competencies.CompetencyRepository;
import zm.hashcode.tics.services.training.competencies.CompetencyService;

/**
 *
 * @author geek
 */
@Service
public class CompetencyServiceImpl implements CompetencyService {

    @Autowired
    private CompetencyRepository competencyRepository;

    @Override
    public Competency find(String id) {
        return competencyRepository.findOne(id);
    }

    @Override
    public Competency persist(Competency entity) {
        return competencyRepository.save(entity);
    }

    @Override
    public Competency merge(Competency entity) {
        return competencyRepository.save(entity);
    }

    @Override
    public void remove(Competency entity) {
        competencyRepository.delete(entity);
    }

    @Override
    public List<Competency> findAll() {
        return ImmutableList.copyOf(competencyRepository.findAll());
    }
}
