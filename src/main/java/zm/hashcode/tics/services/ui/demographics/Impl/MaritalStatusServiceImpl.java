/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.MaritalStatus;
import zm.hashcode.tics.repository.ui.demographics.MaritalStatusRepository;
import zm.hashcode.tics.services.ui.demographics.MaritalStatusService;

/**
 *
 * @author geek
 */
@Service
public class MaritalStatusServiceImpl implements MaritalStatusService {

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @Override
    public MaritalStatus find(String id) {
        return maritalStatusRepository.findOne(id);
    }

    @Override
    public MaritalStatus persist(MaritalStatus entity) {
        return maritalStatusRepository.save(entity);
    }

    @Override
    public MaritalStatus merge(MaritalStatus entity) {
        return maritalStatusRepository.save(entity);
    }

    @Override
    public void remove(MaritalStatus entity) {
        maritalStatusRepository.delete(entity);
    }

    @Override
    public List<MaritalStatus> findAll() {
        return ImmutableList.copyOf(maritalStatusRepository.findAll());
    }
}
