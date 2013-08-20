/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.position.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.position.DepartureReason;
import zm.hashcode.tics.repository.ui.position.DepartureReasonRepository;
import zm.hashcode.tics.services.ui.position.DepartureReasonService;

/**
 *
 * @author geek
 */
@Service
public class DepartureReasonServiceImpl implements DepartureReasonService {

    @Autowired
    private DepartureReasonRepository departureReasonRepository;

    @Override
    public DepartureReason find(String id) {
        return departureReasonRepository.findOne(id);
    }

    @Override
    public DepartureReason persist(DepartureReason entity) {
        return departureReasonRepository.save(entity);
    }

    @Override
    public DepartureReason merge(DepartureReason entity) {
        return departureReasonRepository.save(entity);
    }

    @Override
    public void remove(DepartureReason entity) {
        departureReasonRepository.delete(entity);
    }

    @Override
    public List<DepartureReason> findAll() {
        return ImmutableList.copyOf(departureReasonRepository.findAll());
    }
}
