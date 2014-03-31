/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.people.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Sort;
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
    @Caching(evict = {
        @CacheEvict(value = "persons", allEntries = true)
    })
    public Person persist(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    @Caching(evict = {
        @CacheEvict(value = "persons", allEntries = true)
    })
    public Person merge(Person entity) {
        return personRepository.save(entity);
    }

    @Override
    @Caching(evict = {
        @CacheEvict(value = "persons", allEntries = true)
    })
    public void remove(Person entity) {
        personRepository.delete(entity);
    }

    @Override
    @Cacheable("persons")
    public List<Person> findAll() {
        return ImmutableList.copyOf(personRepository.findAll(sortByName()));
    }

    private Sort sortByName() {
        return new Sort(
                new Sort.Order(Sort.Direction.ASC, "surname"));
    }
}
