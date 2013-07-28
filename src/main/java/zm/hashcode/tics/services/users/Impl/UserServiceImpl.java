/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.users.Impl;

import com.google.gwt.thirdparty.guava.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.users.User;
import zm.hashcode.tics.repository.users.UsersRepository;
import zm.hashcode.tics.services.users.UserService;

/**
 *
 * @author boniface
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public User persist(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User merge(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User find(String id) {
        return usersRepository.findOne(id);
    }

    @Override
    public void remove(User user) {
        usersRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return ImmutableList.copyOf(usersRepository.findAll(sortByLastNameAndFirstNameAsc()));
    }

    private Sort sortByLastNameAndFirstNameAsc() {
        return new Sort(
                new Sort.Order(Sort.Direction.ASC, "lastname"),
                new Sort.Order(Sort.Direction.ASC, "firstname"));
    }
}
