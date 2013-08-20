/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.position.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.position.Position;
import zm.hashcode.tics.repository.ui.position.PositionRepository;
import zm.hashcode.tics.services.ui.position.PositionService;

/**
 *
 * @author geek
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Position find(String id) {
        return positionRepository.findOne(id);
    }

    @Override
    public Position persist(Position entity) {
        return positionRepository.save(entity);
    }

    @Override
    public Position merge(Position entity) {
        return positionRepository.save(entity);
    }

    @Override
    public void remove(Position entity) {
        positionRepository.delete(entity);
    }

    @Override
    public List<Position> findAll() {
        return ImmutableList.copyOf(positionRepository.findAll());
    }
}
