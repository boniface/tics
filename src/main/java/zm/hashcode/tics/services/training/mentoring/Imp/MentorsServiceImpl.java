/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.Mentors;
import zm.hashcode.tics.repository.training.mentoring.MentorsRepository;
import zm.hashcode.tics.services.training.mentoring.MentorsService;

/**
 *
 * @author geek
 */
@Service
public class MentorsServiceImpl implements MentorsService {

    @Autowired
    private MentorsRepository mentorsRepository;

    @Override
    public Mentors find(String id) {
        return mentorsRepository.findOne(id);
    }

    @Override
    public Mentors persist(Mentors entity) {
        return mentorsRepository.save(entity);
    }

    @Override
    public Mentors merge(Mentors entity) {
        return mentorsRepository.save(entity);
    }

    @Override
    public void remove(Mentors entity) {
        mentorsRepository.delete(entity);
    }

    @Override
    public List<Mentors> findAll() {
        return ImmutableList.copyOf(mentorsRepository.findAll());
    }
}
