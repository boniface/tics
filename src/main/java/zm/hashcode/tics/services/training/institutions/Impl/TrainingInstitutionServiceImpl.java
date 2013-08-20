/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.institutions.TrainingInstitution;
import zm.hashcode.tics.repository.training.institutions.TrainingInstitutionRepository;
import zm.hashcode.tics.services.training.institutions.TrainingInstitutionService;

/**
 *
 * @author geek
 */
@Service
public class TrainingInstitutionServiceImpl implements TrainingInstitutionService {

    @Autowired
    private TrainingInstitutionRepository trainingInstitutionRepository;

    @Override
    public TrainingInstitution find(String id) {
        return trainingInstitutionRepository.findOne(id);
    }

    @Override
    public TrainingInstitution persist(TrainingInstitution entity) {
        return trainingInstitutionRepository.save(entity);
    }

    @Override
    public TrainingInstitution merge(TrainingInstitution entity) {
        return trainingInstitutionRepository.save(entity);
    }

    @Override
    public void remove(TrainingInstitution entity) {
        trainingInstitutionRepository.delete(entity);
    }

    @Override
    public List<TrainingInstitution> findAll() {
        return ImmutableList.copyOf(trainingInstitutionRepository.findAll());
    }
}
