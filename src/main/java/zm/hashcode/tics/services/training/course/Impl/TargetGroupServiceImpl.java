/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.course.TargetGroup;
import zm.hashcode.tics.services.training.course.TargetGroupService;
import zm.hashcode.tics.repository.training.course.TragetGroupRepository;

/**
 *
 * @author geek
 */
@Service
public class TargetGroupServiceImpl implements TargetGroupService {

    @Autowired
    private TragetGroupRepository TargetGroupRepository;

    @Override
    public TargetGroup find(String id) {
        return TargetGroupRepository.findOne(id);
    }

    @Override
    public TargetGroup persist(TargetGroup entity) {
        return TargetGroupRepository.save(entity);
    }

    @Override
    public TargetGroup merge(TargetGroup entity) {
        return TargetGroupRepository.save(entity);
    }

    @Override
    public void remove(TargetGroup entity) {
        TargetGroupRepository.delete(entity);
    }

    @Override
    public List<TargetGroup> findAll() {
        return ImmutableList.copyOf(TargetGroupRepository.findAll());
    }
}
