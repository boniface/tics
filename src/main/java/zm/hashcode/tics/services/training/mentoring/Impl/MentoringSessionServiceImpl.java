/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSession;
import zm.hashcode.tics.repository.training.mentoring.MentoringSessionRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringSessionService;

/**
 *
 * @author geek
 */
@Service
public class MentoringSessionServiceImpl implements MentoringSessionService {

    @Autowired
    private MentoringSessionRepository mentoringSessionRepository;

    @Override
    public MentoringSession find(String id) {
        return mentoringSessionRepository.findOne(id);
    }

    @Override
    public MentoringSession persist(MentoringSession entity) {
        return mentoringSessionRepository.save(entity);
    }

    @Override
    public MentoringSession merge(MentoringSession entity) {
        return mentoringSessionRepository.save(entity);
    }

    @Override
    public void remove(MentoringSession entity) {
        mentoringSessionRepository.delete(entity);
    }

    @Override
    public List<MentoringSession> findAll() {
        return ImmutableList.copyOf(mentoringSessionRepository.findAll());
    }
}
