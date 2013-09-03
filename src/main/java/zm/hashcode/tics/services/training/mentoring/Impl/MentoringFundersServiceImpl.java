/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.mentoring.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.mentoring.MentoringFunders;
import zm.hashcode.tics.repository.training.mentoring.MentoringFundersRepository;
import zm.hashcode.tics.services.training.mentoring.MentoringFundersService;

/**
 *
 * @author geek
 */
@Service
public class MentoringFundersServiceImpl implements MentoringFundersService {

    @Autowired
    private MentoringFundersRepository mentoringFundersRepository;

    @Override
    public MentoringFunders find(String id) {
        return mentoringFundersRepository.findOne(id);
    }

    @Override
    public MentoringFunders persist(MentoringFunders entity) {
        return mentoringFundersRepository.save(entity);
    }

    @Override
    public MentoringFunders merge(MentoringFunders entity) {
        return mentoringFundersRepository.save(entity);
    }

    @Override
    public void remove(MentoringFunders entity) {
        mentoringFundersRepository.delete(entity);
    }

    @Override
    public List<MentoringFunders> findAll() {
        return ImmutableList.copyOf(mentoringFundersRepository.findAll());
    }
}
