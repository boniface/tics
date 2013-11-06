/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.repository.offices.FacilityRepository;
import zm.hashcode.tics.services.offices.FacilityService;

/**
 *
 * @author boniface
 */
@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Facility find(String id) {
        return facilityRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = "facilities", allEntries = true)
    public Facility persist(Facility entity) {
        return facilityRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "facilities", allEntries = true)
    public Facility merge(Facility entity) {
        return facilityRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "facilities", allEntries = true)
    public void remove(Facility entity) {
        facilityRepository.delete(entity);
    }

    @Override
    @Cacheable("facilities")
    public List<Facility> findAll() {
        return ImmutableList.copyOf(facilityRepository.findAll(sortByFacilityName()));
    }

    private Sort sortByFacilityName() {
        return new Sort(
                new Sort.Order(Sort.Direction.ASC, "facilityName"));
    }
}
