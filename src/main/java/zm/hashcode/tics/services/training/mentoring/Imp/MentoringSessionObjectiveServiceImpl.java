/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionObjective;
import zm.hashcode.tics.repository.training.mentoring.MentoringSessionObjectiveRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringSessionObjectiveService;

/**
 *
 * @author geek
 */
@Service
public class MentoringSessionObjectiveServiceImpl implements MentoringSessionObjectiveService {

    @Autowired
    private MentoringSessionObjectiveRepository mentoringSessionObjectiveRepository;

    @Override
    public MentoringSessionObjective find(String id) {
        return mentoringSessionObjectiveRepository.findOne(id);
    }

    @Override
    public MentoringSessionObjective persist(MentoringSessionObjective entity) {
        return mentoringSessionObjectiveRepository.save(entity);
    }

    @Override
    public MentoringSessionObjective merge(MentoringSessionObjective entity) {
        return mentoringSessionObjectiveRepository.save(entity);
    }

    @Override
    public void remove(MentoringSessionObjective entity) {
        mentoringSessionObjectiveRepository.delete(entity);
    }

    @Override
    public List<MentoringSessionObjective> findAll() {
        return ImmutableList.copyOf(mentoringSessionObjectiveRepository.findAll());
    }
}
