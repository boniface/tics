/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.repository.ui.demographics.IdentificationTypeRepository;
import zm.hashcode.tics.services.ui.demographics.IdentificationTypeService;

/**
 *
 * @author geek
 */
@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService {

    @Autowired
    private IdentificationTypeRepository identificationTypeRepository;

    @Override
    public IdentificationType find(String id) {
        return identificationTypeRepository.findOne(id);
    }

    @Override
    public IdentificationType persist(IdentificationType entity) {
        return identificationTypeRepository.save(entity);
    }

    @Override
    public IdentificationType merge(IdentificationType entity) {
        return identificationTypeRepository.save(entity);
    }

    @Override
    public void remove(IdentificationType entity) {
        identificationTypeRepository.delete(entity);
    }

    @Override
    public List<IdentificationType> findAll() {
        return ImmutableList.copyOf(identificationTypeRepository.findAll());
    }
}
