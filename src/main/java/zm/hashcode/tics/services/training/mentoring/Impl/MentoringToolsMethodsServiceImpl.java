/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringToolsMethods;
import zm.hashcode.tics.repository.training.mentoring.MentoringToolsMethodsRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringToolsMethodsService;

/**
 *
 * @author geek
 */
@Service
public class MentoringToolsMethodsServiceImpl implements MentoringToolsMethodsService {

    @Autowired
    private MentoringToolsMethodsRepository mentoringToolsMethodsRepository;

    @Override
    public MentoringToolsMethods find(String id) {
        return mentoringToolsMethodsRepository.findOne(id);
    }

    @Override
    public MentoringToolsMethods persist(MentoringToolsMethods entity) {
        return mentoringToolsMethodsRepository.save(entity);
    }

    @Override
    public MentoringToolsMethods merge(MentoringToolsMethods entity) {
        return mentoringToolsMethodsRepository.save(entity);
    }

    @Override
    public void remove(MentoringToolsMethods entity) {
        mentoringToolsMethodsRepository.delete(entity);
    }

    @Override
    public List<MentoringToolsMethods> findAll() {
        return ImmutableList.copyOf(mentoringToolsMethodsRepository.findAll());
    }
}
