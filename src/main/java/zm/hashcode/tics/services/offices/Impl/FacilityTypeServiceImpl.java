/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.FacilityType;
import zm.hashcode.tics.repository.offices.FacilityTypeRepository;
import zm.hashcode.tics.services.offices.FacilityTypeService;

/**
 *
 * @author ColinWa
 */
@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {

    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    @Override
    public FacilityType find(String id) {
        return facilityTypeRepository.findOne(id);
    }

    @Override
    public FacilityType persist(FacilityType entity) {
        return facilityTypeRepository.save(entity);
    }

    @Override
    public FacilityType merge(FacilityType entity) {
        return facilityTypeRepository.save(entity);
    }

    @Override
    public void remove(FacilityType entity) {
        facilityTypeRepository.delete(entity);
    }

    @Override
    public List<FacilityType> findAll() {
        return ImmutableList.copyOf(facilityTypeRepository.findAll());
    }
}
