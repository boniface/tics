/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.location.ContactList;
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
    public ContactList find(String id) {
        return contactListRepository.findOne(id);
    }

    @Override
    public ContactList persist(ContactList entity) {
        return contactListRepository.save(entity);
    }

    @Override
    public ContactList merge(ContactList entity) {
        return contactListRepository.save(entity);
    }

    @Override
    public void remove(ContactList entity) {
        contactListRepository.delete(entity);
    }

    @Override
    public List<ContactList> findAll() {
        return ImmutableList.copyOf(contactListRepository.findAll());
    }
}
