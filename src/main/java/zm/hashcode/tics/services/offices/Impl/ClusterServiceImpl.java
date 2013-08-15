/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.Cluster;
import zm.hashcode.tics.repository.offices.ClusterRepository;
import zm.hashcode.tics.services.offices.ClusterService;

/**
 *
 * @author ColinWa
 */
@Service
public class ClusterServiceImpl implements ClusterService {

    @Autowired
    private ClusterRepository clusterRepository;

    @Override
    public Cluster find(String id) {
        return clusterRepository.findOne(id);
    }

    @Override
    public Cluster persist(Cluster entity) {
        return clusterRepository.save(entity);
    }

    @Override
    public Cluster merge(Cluster entity) {
        return clusterRepository.save(entity);
    }

    @Override
    public void remove(Cluster entity) {
        clusterRepository.delete(entity);
    }

    @Override
    public List<Cluster> findAll() {
        return ImmutableList.copyOf(clusterRepository.findAll());
    }
}
