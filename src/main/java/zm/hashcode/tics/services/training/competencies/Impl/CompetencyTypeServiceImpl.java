/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.competencies.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.competencies.CompetencyType;
import zm.hashcode.tics.repository.training.competencies.CompetencyTypeRepository;
import zm.hashcode.tics.services.training.competencies.CompetencyTypeService;

/**
 *
 * @author geek
 */
@Service
public class CompetencyTypeServiceImpl implements CompetencyTypeService {

    @Autowired
    private CompetencyTypeRepository competencyTypeRepository;

    @Override
    public CompetencyType find(String id) {
        return competencyTypeRepository.findOne(id);
    }

    @Override
    public CompetencyType persist(CompetencyType entity) {
        return competencyTypeRepository.save(entity);
    }

    @Override
    public CompetencyType merge(CompetencyType entity) {
        return competencyTypeRepository.save(entity);
    }

    @Override
    public void remove(CompetencyType entity) {
        competencyTypeRepository.delete(entity);
    }

    @Override
    public List<CompetencyType> findAll() {
        return ImmutableList.copyOf(competencyTypeRepository.findAll());
    }
}
