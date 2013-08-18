/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.location.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Location persist(Location entity) {
        return locationRepository.save(entity);
    }

    @Override
    public Location merge(Location entity) {
        return locationRepository.save(entity);
    }

    @Override
    public void remove(Location entity) {
        locationRepository.delete(entity);
    }

    @Override
    public List<Location> findAll() {
        return ImmutableList.copyOf(locationRepository.findAll());
    }
}
