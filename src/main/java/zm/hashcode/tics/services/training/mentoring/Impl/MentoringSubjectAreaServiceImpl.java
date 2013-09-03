/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;
import zm.hashcode.tics.repository.training.mentoring.MentoringSubjectAreaRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringSubjectAreaService;

/**
 *
 * @author geek
 */
@Service
public class MentoringSubjectAreaServiceImpl implements MentoringSubjectAreaService {

    @Autowired
    private MentoringSubjectAreaRepository mentoringSubjectAreaRepository;

    @Override
    public MentoringSubjectArea find(String id) {
        return mentoringSubjectAreaRepository.findOne(id);
    }

    @Override
    public MentoringSubjectArea persist(MentoringSubjectArea entity) {
        return mentoringSubjectAreaRepository.save(entity);
    }

    @Override
    public MentoringSubjectArea merge(MentoringSubjectArea entity) {
        return mentoringSubjectAreaRepository.save(entity);
    }

    @Override
    public void remove(MentoringSubjectArea entity) {
        mentoringSubjectAreaRepository.delete(entity);
    }

    @Override
    public List<MentoringSubjectArea> findAll() {
        return ImmutableList.copyOf(mentoringSubjectAreaRepository.findAll());
    }
}
