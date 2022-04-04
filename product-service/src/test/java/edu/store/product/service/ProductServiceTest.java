package edu.store.product.service;

import edu.store.product.domain.model.Category;
import edu.store.product.domain.model.Product;
import edu.store.product.repository.ProductRepository;
import edu.store.product.service.mock.CategoryMock;
import edu.store.product.service.mock.ProductMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    ProductService productService;

    ProductMock productMock;
    CategoryMock categoryMock;
    @Mock
    ProductRepository productRepository;

    @BeforeAll
    public void setUp() {
        initMocks(this);
        productService = new ProductService(productRepository);
        categoryMock = new CategoryMock();
        productMock = new ProductMock(categoryMock);

        Category defaultCategory = categoryMock.getDefaultComplete();
        List<Product> defaultListByCategory = productMock.getCompleteListDefaultCategory();

        Mockito.when(productRepository.findByCategory(defaultCategory))
                .thenReturn(defaultListByCategory);
    }

    @Test
    void testFindByCategoryOk() {
        Category defaultCategory = categoryMock.getDefaultComplete();
        List<Product> products = productService.findByCategory(defaultCategory);

        assertTrue(products.stream().allMatch(product -> product.getCategory().equals(defaultCategory)));
        verify(productRepository, times(1)).findByCategory(defaultCategory);
    }
}