/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringAreasList;
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
    public MentoringAreasList find(String id) {
        return mentoringAreasListRepository.findOne(id);
    }

    @Override
    public MentoringAreasList persist(MentoringAreasList entity) {
        return mentoringAreasListRepository.save(entity);
    }

    @Override
    public MentoringAreasList merge(MentoringAreasList entity) {
        return mentoringAreasListRepository.save(entity);
    }

    @Override
    public void remove(MentoringAreasList entity) {
        mentoringAreasListRepository.delete(entity);
    }

    @Override
    public List<MentoringAreasList> findAll() {
        return ImmutableList.copyOf(mentoringAreasListRepository.findAll());
    }
}
