/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.LanguageProficiency;
import zm.hashcode.tics.repository.ui.demographics.LanguageProficiencyRepository;
import zm.hashcode.tics.services.ui.demographics.LanguageProficiencyService;

/**
 *
 * @author geek
 */
@Service
public class LanguageProficiencyServiceImpl implements LanguageProficiencyService {

    @Autowired
    private LanguageProficiencyRepository languageProficiencyRepository;

    @Override
    public LanguageProficiency find(String id) {
        return languageProficiencyRepository.findOne(id);
    }

    @Override
    public LanguageProficiency persist(LanguageProficiency entity) {
        return languageProficiencyRepository.save(entity);
    }

    @Override
    public LanguageProficiency merge(LanguageProficiency entity) {
        return languageProficiencyRepository.save(entity);
    }

    @Override
    public void remove(LanguageProficiency entity) {
        languageProficiencyRepository.delete(entity);
    }

    @Override
    public List<LanguageProficiency> findAll() {
        return ImmutableList.copyOf(languageProficiencyRepository.findAll());
    }
}
