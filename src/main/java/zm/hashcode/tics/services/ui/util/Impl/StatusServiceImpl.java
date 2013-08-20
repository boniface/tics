/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.util.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.util.Status;
import zm.hashcode.tics.repository.ui.util.StatusRepository;
import zm.hashcode.tics.services.ui.util.StatusService;

/**
 *
 * @author geek
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status find(String id) {
        return statusRepository.findOne(id);
    }

    @Override
    public Status persist(Status entity) {
        return statusRepository.save(entity);
    }

    @Override
    public Status merge(Status entity) {
        return statusRepository.save(entity);
    }

    @Override
    public void remove(Status entity) {
        statusRepository.delete(entity);
    }

    @Override
    public List<Status> findAll() {
        return ImmutableList.copyOf(statusRepository.findAll());
    }
}
