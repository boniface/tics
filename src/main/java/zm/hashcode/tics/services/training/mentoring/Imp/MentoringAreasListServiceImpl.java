/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSubjectArea;
import zm.hashcode.tics.repository.training.mentoring.MentoringAreasListRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringAreasListService;

/**
 *
 * @author geek
 */
@Service
public class MentoringAreasListServiceImpl implements MentoringAreasListService {

    @Autowired
    private MentoringAreasListRepository mentoringAreasListRepository;

    @Override
    public MentoringSubjectArea find(String id) {
        return mentoringAreasListRepository.findOne(id);
    }

    @Override
    public MentoringSubjectArea persist(MentoringSubjectArea entity) {
        return mentoringAreasListRepository.save(entity);
    }

    @Override
    public MentoringSubjectArea merge(MentoringSubjectArea entity) {
        return mentoringAreasListRepository.save(entity);
    }

    @Override
    public void remove(MentoringSubjectArea entity) {
        mentoringAreasListRepository.delete(entity);
    }

    @Override
    public List<MentoringSubjectArea> findAll() {
        return ImmutableList.copyOf(mentoringAreasListRepository.findAll());
    }
}
