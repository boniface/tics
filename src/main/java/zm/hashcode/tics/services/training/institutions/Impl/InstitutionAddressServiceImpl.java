/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.institutions.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.institutions.InstitutionAddress;
import zm.hashcode.tics.repository.training.institutions.InstitutionAddressRepository;
import zm.hashcode.tics.services.training.institutions.InstitutionAddressService;

/**
 *
 * @author geek
 */
@Service
public class InstitutionAddressServiceImpl implements InstitutionAddressService {

    @Autowired
    private InstitutionAddressRepository institutionAddressRepository;

    @Override
    public InstitutionAddress find(String id) {
        return institutionAddressRepository.findOne(id);
    }

    @Override
    public InstitutionAddress persist(InstitutionAddress entity) {
        return institutionAddressRepository.save(entity);
    }

    @Override
    public InstitutionAddress merge(InstitutionAddress entity) {
        return institutionAddressRepository.save(entity);
    }

    @Override
    public void remove(InstitutionAddress entity) {
        institutionAddressRepository.delete(entity);
    }

    @Override
    public List<InstitutionAddress> findAll() {
        return ImmutableList.copyOf(institutionAddressRepository.findAll());
    }
}
