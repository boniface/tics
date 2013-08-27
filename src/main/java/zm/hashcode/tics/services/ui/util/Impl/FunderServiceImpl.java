/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.util.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.util.Funder;
import zm.hashcode.tics.repository.ui.util.FunderRepository;
import zm.hashcode.tics.services.ui.util.FunderService;

/**
 *
 * @author geek
 */
@Service
public class FunderServiceImpl implements FunderService {

    @Autowired
    private FunderRepository funderRepository;

    @Override
    public Funder find(String id) {
        return funderRepository.findOne(id);
    }

    @Override
    public Funder persist(Funder entity) {
        return funderRepository.save(entity);
    }

    @Override
    public Funder merge(Funder entity) {
        return funderRepository.save(entity);
    }

    @Override
    public void remove(Funder entity) {
        funderRepository.delete(entity);
    }

    @Override
    public List<Funder> findAll() {
        return ImmutableList.copyOf(funderRepository.findAll());
    }
}
