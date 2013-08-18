/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.Language;
import zm.hashcode.tics.repository.ui.demographics.LanguageRepository;
import zm.hashcode.tics.services.ui.demographics.LanguageService;

/**
 *
 * @author geek
 */
@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language find(String id) {
        return languageRepository.findOne(id);
    }

    @Override
    public Language persist(Language entity) {
        return languageRepository.save(entity);
    }

    @Override
    public Language merge(Language entity) {
        return languageRepository.save(entity);
    }

    @Override
    public void remove(Language entity) {
        languageRepository.delete(entity);
    }

    @Override
    public List<Language> findAll() {
        return ImmutableList.copyOf(languageRepository.findAll());
    }
}
