/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.location.AddressType;
import zm.hashcode.tics.repository.ui.location.AddressTypeRepository;
import zm.hashcode.tics.services.ui.location.AddressTypeService;

/**
 *
 * @author geek
 */
@Service
public class AddressTypeServiceImpl implements AddressTypeService {

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Override
    public AddressType find(String id) {
        return addressTypeRepository.findOne(id);
    }

    @Override
    public AddressType persist(AddressType entity) {
        return addressTypeRepository.save(entity);
    }

    @Override
    public AddressType merge(AddressType entity) {
        return addressTypeRepository.save(entity);
    }

    @Override
    public void remove(AddressType entity) {
        addressTypeRepository.delete(entity);
    }

    @Override
    public List<AddressType> findAll() {
        return ImmutableList.copyOf(addressTypeRepository.findAll());
    }
}
