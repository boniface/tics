/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.Role;
import zm.hashcode.tics.repository.ui.demographics.RoleRepository;
import zm.hashcode.tics.services.ui.demographics.RoleService;

/**
 *
 * @author boniface
 */
@Service
public class RoleserviceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role find(String id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role persist(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role merge(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void remove(Role entity) {
        roleRepository.delete(entity);
    }

    @Override
    public List<Role> findAll() {
        return ImmutableList.copyOf(roleRepository.findAll());
    }
}
