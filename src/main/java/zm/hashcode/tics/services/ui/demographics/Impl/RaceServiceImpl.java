/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.repository.ui.demographics.RaceRepository;
import zm.hashcode.tics.services.ui.demographics.RaceService;

/**
 *
 * @author geek
 */
@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    private RaceRepository raceRepository;

    @Override
    public Race find(String id) {
        return raceRepository.findOne(id);
    }

    @Override
    public Race persist(Race entity) {
        return raceRepository.save(entity);
    }

    @Override
    public Race merge(Race entity) {
        return raceRepository.save(entity);
    }

    @Override
    public void remove(Race entity) {
        raceRepository.delete(entity);
    }

    @Override
    public List<Race> findAll() {
        return ImmutableList.copyOf(raceRepository.findAll());
    }
}
