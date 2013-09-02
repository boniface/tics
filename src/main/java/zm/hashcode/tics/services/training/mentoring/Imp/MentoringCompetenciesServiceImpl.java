/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringCompetencies;
import zm.hashcode.tics.repository.training.mentoring.MentoringCompetenciesRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringCompetenciesService;

/**
 *
 * @author geek
 */
@Service
public class MentoringCompetenciesServiceImpl implements MentoringCompetenciesService {

    @Autowired
    private MentoringCompetenciesRepository mentoringCompetenciesRepository;

    @Override
    public MentoringCompetencies find(String id) {
        return mentoringCompetenciesRepository.findOne(id);
    }

    @Override
    public MentoringCompetencies persist(MentoringCompetencies entity) {
        return mentoringCompetenciesRepository.save(entity);
    }

    @Override
    public MentoringCompetencies merge(MentoringCompetencies entity) {
        return mentoringCompetenciesRepository.save(entity);
    }

    @Override
    public void remove(MentoringCompetencies entity) {
        mentoringCompetenciesRepository.delete(entity);
    }

    @Override
    public List<MentoringCompetencies> findAll() {
        return ImmutableList.copyOf(mentoringCompetenciesRepository.findAll());
    }
}
