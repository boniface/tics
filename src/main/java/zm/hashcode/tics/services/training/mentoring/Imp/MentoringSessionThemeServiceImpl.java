/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Imp;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringSessionTheme;
import zm.hashcode.tics.repository.training.mentoring.MentoringSessionThemeRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringSessionThemeService;

/**
 *
 * @author geek
 */
@Service
public class MentoringSessionThemeServiceImpl implements MentoringSessionThemeService {

    @Autowired
    private MentoringSessionThemeRepository mentoringSessionThemeRepository;

    @Override
    public MentoringSessionTheme find(String id) {
        return mentoringSessionThemeRepository.findOne(id);
    }

    @Override
    public MentoringSessionTheme persist(MentoringSessionTheme entity) {
        return mentoringSessionThemeRepository.save(entity);
    }

    @Override
    public MentoringSessionTheme merge(MentoringSessionTheme entity) {
        return mentoringSessionThemeRepository.save(entity);
    }

    @Override
    public void remove(MentoringSessionTheme entity) {
        mentoringSessionThemeRepository.delete(entity);
    }

    @Override
    public List<MentoringSessionTheme> findAll() {
        return ImmutableList.copyOf(mentoringSessionThemeRepository.findAll());
    }
}
