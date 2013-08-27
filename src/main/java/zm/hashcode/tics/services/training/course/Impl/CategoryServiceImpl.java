/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services.training.course.Impl;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.tics.domain.training.course.Category;
import zm.hashcode.tics.repository.training.course.CategoryRepository;
import zm.hashcode.tics.services.training.course.CategoryService;

/**
 *
 * @author geek
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category find(String id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category persist(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Category merge(Category entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public void remove(Category entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public List<Category> findAll() {
        return ImmutableList.copyOf(categoryRepository.findAll());
    }
}
