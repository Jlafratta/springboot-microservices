package edu.store.product.service.mock;

import edu.store.product.domain.model.Category;
import edu.store.product.domain.model.Product;
import edu.store.product.repository.CategoryRepository;
import edu.store.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Service
public class MockService {

    @Value("${mock-data}")
    private final Boolean mockData = false;

    @Autowired
    private CategoryRepository categoryRepository;
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
        List<Category> categories = List.of(
                Category.builder()
                        .name("New")
                        .build(),
                Category.builder()
                        .name("Star")
                        .build(),
                Category.builder()
                        .name("Season")
                        .build(),
                Category.builder()
                        .name("Supporter")
                        .build(),
                Category.builder()
                        .name("Downward")
                        .build()
        );
        categoryRepository.saveAll(categories);
    }

    private void mockProduct() {
        productRepository.saveAll(List.of(
                Product.builder()
                        .name("Impresora 3D Artillery Genius")
                        .description("¡La impresión 3D es una auténtica revolución en la manera de fabricar! Con esta impresora Artillery Genius vas a poder realizar réplicas de tus diseños tridimensionales y ver cómo cobran vida.")
                        .stock(3)
                        .price(BigDecimal.valueOf(74999))
                        .category(Category.builder()
                                .id(1L)
                                .build())
                        .build(),
                Product.builder()
                        .name("Sony PlayStation 3 Slim 160GB Standard  color charcoal black")
                        .description("Con tu consola PlayStation 3 tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.")
                        .stock(71)
                        .price(BigDecimal.valueOf(40000))
                        .category(Category.builder()
                                .id(2L)
                                .build())
                        .build()
        ));
    }

}
