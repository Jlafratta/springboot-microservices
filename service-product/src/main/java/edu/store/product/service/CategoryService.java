package edu.store.product.service;

import edu.store.product.domain.model.Category;
import edu.store.product.repository.CategoryRepository;
import edu.store.product.service.generic.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseCrudService<Category, Long> {

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        setRepository(categoryRepository);
    }
}
