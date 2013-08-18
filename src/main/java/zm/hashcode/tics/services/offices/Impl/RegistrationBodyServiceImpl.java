/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.RegistrationBody;
import zm.hashcode.tics.repository.people.RegistrationBodyRepository;
import zm.hashcode.tics.services.offices.RegistrationBodyService;

/**
 *
 * @author geek
 */
@Service
public class RegistrationBodyServiceImpl implements RegistrationBodyService {

    @Autowired
    private RegistrationBodyRepository registrationBodyepository;

    @Override
    public RegistrationBody find(String id) {
        return registrationBodyepository.findOne(id);
    }

    @Override
    public RegistrationBody persist(RegistrationBody entity) {
        return registrationBodyepository.save(entity);
    }

    @Override
    public RegistrationBody merge(RegistrationBody entity) {
        return registrationBodyepository.save(entity);
    }

    @Override
    public void remove(RegistrationBody entity) {
        registrationBodyepository.delete(entity);
    }

    @Override
    public List<RegistrationBody> findAll() {
        return ImmutableList.copyOf(registrationBodyepository.findAll());
    }
}
