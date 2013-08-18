/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.location.LocationType;
import zm.hashcode.tics.repository.ui.location.LocationTypeRepository;
import zm.hashcode.tics.services.ui.location.LocationTypeService;

/**
 *
 * @author geek
 */
@Service
public class LocationTypeServiceImpl implements LocationTypeService {

    @Autowired
    private LocationTypeRepository locationTypeRepository;

    @Override
    public LocationType find(String id) {
        return locationTypeRepository.findOne(id);
    }

    @Override
    public LocationType persist(LocationType entity) {
        return locationTypeRepository.save(entity);
    }

    @Override
    public LocationType merge(LocationType entity) {
        return locationTypeRepository.save(entity);
    }

    @Override
    public void remove(LocationType entity) {
        locationTypeRepository.delete(entity);
    }

    @Override
    public List<LocationType> findAll() {
        return ImmutableList.copyOf(locationTypeRepository.findAll());
    }
}
