/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.SessionType;
import zm.hashcode.tics.repository.training.mentoring.SessionTypeRepository;
import zm.hashcode.tics.services.training.mentoring.SessionTypeService;

/**
 *
 * @author geek
 */
@Service
public class SessionTypeServiceImpl implements SessionTypeService {

    @Autowired
    private SessionTypeRepository SessionTypeRepository;

    @Override
    public SessionType find(String id) {
        return SessionTypeRepository.findOne(id);
    }

    @Override
    public SessionType persist(SessionType entity) {
        return SessionTypeRepository.save(entity);
    }

    @Override
    public SessionType merge(SessionType entity) {
        return SessionTypeRepository.save(entity);
    }

    @Override
    public void remove(SessionType entity) {
        SessionTypeRepository.delete(entity);
    }

    @Override
    public List<SessionType> findAll() {
        return ImmutableList.copyOf(SessionTypeRepository.findAll());
    }
}
