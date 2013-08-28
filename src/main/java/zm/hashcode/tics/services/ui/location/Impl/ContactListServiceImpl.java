/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.location.Contact;
import zm.hashcode.tics.repository.ui.location.ContactListRepository;
import zm.hashcode.tics.services.ui.location.ContactListService;

/**
 *
 * @author geek
 */
@Service
public class ContactListServiceImpl implements ContactListService {

    @Autowired
    private ContactListRepository contactListRepository;

    @Override
    public Contact find(String id) {
        return contactListRepository.findOne(id);
    }

    @Override
    public Contact persist(Contact entity) {
        return contactListRepository.save(entity);
    }

    @Override
    public Contact merge(Contact entity) {
        return contactListRepository.save(entity);
    }

    @Override
    public void remove(Contact entity) {
        contactListRepository.delete(entity);
    }

    @Override
    public List<Contact> findAll() {
        return ImmutableList.copyOf(contactListRepository.findAll());
    }
}
