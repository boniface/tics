/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.offices.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.offices.Node;
import zm.hashcode.tics.repository.offices.NodeRepository;
import zm.hashcode.tics.services.offices.NodeService;

/**
 *
 * @author ColinWa
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    @Override
    public Node find(String id) {
        return nodeRepository.findOne(id);
    }

    @Override
    public Node persist(Node entity) {
        return nodeRepository.save(entity);
    }

    @Override
    public Node merge(Node entity) {
        return nodeRepository.save(entity);
    }

    @Override
    public void remove(Node entity) {
        nodeRepository.delete(entity);
    }

    @Override
    public List<Node> findAll() {
        return ImmutableList.copyOf(nodeRepository.findAll());
    }
}
