/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.repository.people.PersonRepository;
import zm.hashcode.tics.services.people.PersonService;

/**
 *
 * @author geek
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person find(String id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person persist(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public Person merge(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    public void remove(Person entity) {
        personRepository.delete(entity);
    }

    @Override
    public List<Person> findAll() {
        return ImmutableList.copyOf(personRepository.findAll());
    }
}
