package edu.store.product.service.mock;

import edu.store.product.domain.model.Category;
import edu.store.product.domain.model.Product;
import edu.store.product.repository.CategoryRepository;
import edu.store.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MockService {

    @Value("${mock-data}")
    private final Boolean mockData = false;

    @Autowired
    private CategoryMock categoryMock;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMock productMock;
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void createFullContext() {
        if(mockData) {
            mockCategory();
            mockProduct();
        }
    }

    private void mockCategory() {
        categoryRepository.saveAll(categoryMock.getBasicList());
    }

    private void mockProduct() {
        productRepository.saveAll(productMock.getBasicList());
    }

}
