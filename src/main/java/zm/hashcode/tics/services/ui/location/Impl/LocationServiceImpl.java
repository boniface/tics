/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.repository.ui.location.LocationRepository;
import zm.hashcode.tics.services.ui.location.LocationService;

/**
 *
 * @author geek
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location find(String id) {
        return locationRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = "locations", allEntries = true)
    public Location persist(Location entity) {
        return locationRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "locations", allEntries = true)
    public Location merge(Location entity) {
        return locationRepository.save(entity);
    }

    @Override
    @CacheEvict(value = "locations", allEntries = true)
    public void remove(Location entity) {
        locationRepository.delete(entity);
    }

    @Override
    @Cacheable("locations")
    public List<Location> findAll() {
        return ImmutableList.copyOf(locationRepository.findAll());
    }
}
