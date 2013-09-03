/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringField;
import zm.hashcode.tics.repository.training.mentoring.MentoringFieldRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringFieldService;

/**
 *
 * @author geek
 */
@Service
public class MentoringFieldServiceImpl implements MentoringFieldService {

    @Autowired
    private MentoringFieldRepository mentoringFieldRepository;

    @Override
    public MentoringField find(String id) {
        return mentoringFieldRepository.findOne(id);
    }

    @Override
    public MentoringField persist(MentoringField entity) {
        return mentoringFieldRepository.save(entity);
    }

    @Override
    public MentoringField merge(MentoringField entity) {
        return mentoringFieldRepository.save(entity);
    }

    @Override
    public void remove(MentoringField entity) {
        mentoringFieldRepository.delete(entity);
    }

    @Override
    public List<MentoringField> findAll() {
        return ImmutableList.copyOf(mentoringFieldRepository.findAll());
    }
}
