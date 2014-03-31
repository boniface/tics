/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.ui.demographics.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.ui.demographics.Title;
import zm.hashcode.tics.repository.ui.demographics.TitleRepository;
import zm.hashcode.tics.services.ui.demographics.TitleService;

/**
 *
 * @author geek
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public Title find(String id) {
        return titleRepository.findOne(id);
    }

    @Override
            @Caching(evict = {
        @CacheEvict(value = "titles", allEntries = true)
    })
    public Title persist(Title entity) {
        return titleRepository.save(entity);
    }

    @Override
            @Caching(evict = {
        @CacheEvict(value = "titles", allEntries = true)
    })
    public Title merge(Title entity) {
        return titleRepository.save(entity);
    }

    @Override
        @Caching(evict = {
        @CacheEvict(value = "titles", allEntries = true)
    })
    public void remove(Title entity) {
        titleRepository.delete(entity);
    }

    @Override
      @Cacheable("titles")
    public List<Title> findAll() {
        return ImmutableList.copyOf(titleRepository.findAll());
    }
}
