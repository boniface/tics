/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringObjective;
import zm.hashcode.tics.repository.training.mentoring.MentoringObjectiveRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringObjectiveService;

/**
 *
 * @author geek
 */
@Service
public class MentoringObjectiveServiceImpl implements MentoringObjectiveService {

    @Autowired
    private MentoringObjectiveRepository mentoringObjectiveRepository;

    @Override
    public MentoringObjective find(String id) {
        return mentoringObjectiveRepository.findOne(id);
    }

    @Override
    public MentoringObjective persist(MentoringObjective entity) {
        return mentoringObjectiveRepository.save(entity);
    }

    @Override
    public MentoringObjective merge(MentoringObjective entity) {
        return mentoringObjectiveRepository.save(entity);
    }

    @Override
    public void remove(MentoringObjective entity) {
        mentoringObjectiveRepository.delete(entity);
    }

    @Override
    public List<MentoringObjective> findAll() {
        return ImmutableList.copyOf(mentoringObjectiveRepository.findAll());
    }
}
