/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringTheme;
import zm.hashcode.tics.repository.training.mentoring.MentoringThemeRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringThemeService;

/**
 *
 * @author geek
 */
@Service
public class MentoringThemeServiceImpl implements MentoringThemeService {

    @Autowired
    private MentoringThemeRepository mentoringThemeRepository;

    @Override
    public MentoringTheme find(String id) {
        return mentoringThemeRepository.findOne(id);
    }

    @Override
    public MentoringTheme persist(MentoringTheme entity) {
        return mentoringThemeRepository.save(entity);
    }

    @Override
    public MentoringTheme merge(MentoringTheme entity) {
        return mentoringThemeRepository.save(entity);
    }

    @Override
    public void remove(MentoringTheme entity) {
        mentoringThemeRepository.delete(entity);
    }

    @Override
    public List<MentoringTheme> findAll() {
        return ImmutableList.copyOf(mentoringThemeRepository.findAll());
    }
}
