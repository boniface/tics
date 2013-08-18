/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.repository.ui.demographics.GenderRepository;
import zm.hashcode.tics.services.ui.demographics.GenderService;

/**
 *
 * @author geek
 */
@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Gender find(String id) {
        return genderRepository.findOne(id);
    }

    @Override
    public Gender persist(Gender entity) {
        return genderRepository.save(entity);
    }

    @Override
    public Gender merge(Gender entity) {
        return genderRepository.save(entity);
    }

    @Override
    public void remove(Gender entity) {
        genderRepository.delete(entity);
    }

    @Override
    public List<Gender> findAll() {
        return ImmutableList.copyOf(genderRepository.findAll());
    }
}
