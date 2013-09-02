/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringMentors;
import zm.hashcode.tics.repository.training.mentoring.MentoringMentorsRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringMentorsService;

/**
 *
 * @author geek
 */
@Service
public class MentoringMentorsServiceImpl implements MentoringMentorsService {

    @Autowired
    private MentoringMentorsRepository mentoringMentorsRepository;

    @Override
    public MentoringMentors find(String id) {
        return mentoringMentorsRepository.findOne(id);
    }

    @Override
    public MentoringMentors persist(MentoringMentors entity) {
        return mentoringMentorsRepository.save(entity);
    }

    @Override
    public MentoringMentors merge(MentoringMentors entity) {
        return mentoringMentorsRepository.save(entity);
    }

    @Override
    public void remove(MentoringMentors entity) {
        mentoringMentorsRepository.delete(entity);
    }

    @Override
    public List<MentoringMentors> findAll() {
        return ImmutableList.copyOf(mentoringMentorsRepository.findAll());
    }
}
