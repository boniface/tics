/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.SessionAreasOfStrengthening;
import zm.hashcode.tics.repository.training.mentoring.SessionAreasOfStrengtheningRepository;
import zm.hashcode.tics.services.training.mentoring.SessionAreasOfStrengtheningService;

/**
 *
 * @author geek
 */
@Service
public class SessionAreasOfStrengtheningServiceImpl implements SessionAreasOfStrengtheningService {

    @Autowired
    private SessionAreasOfStrengtheningRepository sessionAreasOfStrengtheningRepository;

    @Override
    public SessionAreasOfStrengthening find(String id) {
        return sessionAreasOfStrengtheningRepository.findOne(id);
    }

    @Override
    public SessionAreasOfStrengthening persist(SessionAreasOfStrengthening entity) {
        return sessionAreasOfStrengtheningRepository.save(entity);
    }

    @Override
    public SessionAreasOfStrengthening merge(SessionAreasOfStrengthening entity) {
        return sessionAreasOfStrengtheningRepository.save(entity);
    }

    @Override
    public void remove(SessionAreasOfStrengthening entity) {
        sessionAreasOfStrengtheningRepository.delete(entity);
    }

    @Override
    public List<SessionAreasOfStrengthening> findAll() {
        return ImmutableList.copyOf(sessionAreasOfStrengtheningRepository.findAll());
    }
}
