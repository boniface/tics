/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import com.mongodb.MongoException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.repository.people.PersonIdentitiesRepository;
import zm.hashcode.tics.services.people.PersonIdentitiesService;

/**
 *
 * @author geek
 */
@Service
public class PersonIdentitiesServiceImpl implements PersonIdentitiesService {

    @Autowired
    private PersonIdentitiesRepository personIdentitiesRepository;

    @Override
    public PersonIdentities find(String id) {
        return personIdentitiesRepository.findOne(id);
    }

    @Override
    public PersonIdentities persist(PersonIdentities entity) throws MongoException.DuplicateKey {
        return personIdentitiesRepository.save(entity);
    }

    @Override
    public PersonIdentities merge(PersonIdentities entity) {
        return personIdentitiesRepository.save(entity);
    }

    @Override
    public void remove(PersonIdentities entity) {
        personIdentitiesRepository.delete(entity);
    }

    @Override
    public List<PersonIdentities> findAll() {
        return ImmutableList.copyOf(personIdentitiesRepository.findAll());
    }
}
