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
    }

    @Test
    void findByCategory() {
        Category cat = categoryMock.getDefaultComplete();
        when(productRepository.findByCategory(cat)).thenReturn(productMock.getCompleteListDefaultCategory());

        List<Product> products = productService.findByCategory(cat);

        assertTrue(products.stream().allMatch(product -> product.getCategory().equals(cat)));
        verify(productRepository, times(1)).findByCategory(cat);
    }
}