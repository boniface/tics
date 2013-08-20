/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.position.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.position.PositionType;
import zm.hashcode.tics.repository.ui.position.PositionTypeRepository;
import zm.hashcode.tics.services.ui.position.PositionTypeService;

/**
 *
 * @author geek
 */
@Service
public class PositionTypeServiceImpl implements PositionTypeService {

    @Autowired
    private PositionTypeRepository positionTypeRepository;

    @Override
    public PositionType find(String id) {
        return positionTypeRepository.findOne(id);
    }

    @Override
    public PositionType persist(PositionType entity) {
        return positionTypeRepository.save(entity);
    }

    @Override
    public PositionType merge(PositionType entity) {
        return positionTypeRepository.save(entity);
    }

    @Override
    public void remove(PositionType entity) {
        positionTypeRepository.delete(entity);
    }

    @Override
    public List<PositionType> findAll() {
        return ImmutableList.copyOf(positionTypeRepository.findAll());
    }
}
