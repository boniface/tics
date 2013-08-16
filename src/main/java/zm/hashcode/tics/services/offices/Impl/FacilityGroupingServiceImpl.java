/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.FacilityGrouping;
import zm.hashcode.tics.repository.offices.FacilityGroupingRepository;
import zm.hashcode.tics.services.offices.FacilityGroupingService;

/**
 *
 * @author ColinWa
 */
@Service
public class FacilityGroupingServiceImpl implements FacilityGroupingService {

    @Autowired
    private FacilityGroupingRepository facilityGroupingRepository;

    @Override
    public FacilityGrouping find(String id) {
        return facilityGroupingRepository.findOne(id);
    }

    @Override
    public FacilityGrouping persist(FacilityGrouping entity) {
        return facilityGroupingRepository.save(entity);
    }

    @Override
    public FacilityGrouping merge(FacilityGrouping entity) {
        return facilityGroupingRepository.save(entity);
    }

    @Override
    public void remove(FacilityGrouping entity) {
        facilityGroupingRepository.delete(entity);
    }

    @Override
    public List<FacilityGrouping> findAll() {
        return ImmutableList.copyOf(facilityGroupingRepository.findAll());
    }
}
