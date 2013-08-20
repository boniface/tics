/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.institutions.TrainingInstructors;
import zm.hashcode.tics.repository.training.institutions.TrainingInstructorsRepository;
import zm.hashcode.tics.services.training.institutions.TrainingInstructorsService;

/**
 *
 * @author geek
 */
@Service
public class TrainingInstructorsServiceImpl implements TrainingInstructorsService {

    @Autowired
    private TrainingInstructorsRepository trainingInstructorsRepository;

    @Override
    public TrainingInstructors find(String id) {
        return trainingInstructorsRepository.findOne(id);
    }

    @Override
    public TrainingInstructors persist(TrainingInstructors entity) {
        return trainingInstructorsRepository.save(entity);
    }

    @Override
    public TrainingInstructors merge(TrainingInstructors entity) {
        return trainingInstructorsRepository.save(entity);
    }

    @Override
    public void remove(TrainingInstructors entity) {
        trainingInstructorsRepository.delete(entity);
    }

    @Override
    public List<TrainingInstructors> findAll() {
        return ImmutableList.copyOf(trainingInstructorsRepository.findAll());
    }
}
