/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionType;
import zm.hashcode.tics.repository.training.mentoring.MentoringSessionTypeRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringSessionTypeService;

/**
 *
 * @author geek
 */
@Service
public class MentoringSessionTypeServiceImpl implements MentoringSessionTypeService {

    @Autowired
    private MentoringSessionTypeRepository MentoringSessionTypeRepository;

    @Override
    public MentoringSessionType find(String id) {
        return MentoringSessionTypeRepository.findOne(id);
    }

    @Override
    public MentoringSessionType persist(MentoringSessionType entity) {
        return MentoringSessionTypeRepository.save(entity);
    }

    @Override
    public MentoringSessionType merge(MentoringSessionType entity) {
        return MentoringSessionTypeRepository.save(entity);
    }

    @Override
    public void remove(MentoringSessionType entity) {
        MentoringSessionTypeRepository.delete(entity);
    }

    @Override
    public List<MentoringSessionType> findAll() {
        return ImmutableList.copyOf(MentoringSessionTypeRepository.findAll());
    }
}
