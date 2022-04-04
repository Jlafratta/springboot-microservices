package edu.store.product.service.mock;

import edu.store.product.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductMock {

    @Autowired
    private CategoryMock categoryMock;

    public Product getOneBasic() {
        return Product.builder()
                .name("Impresora 3D Artillery Genius")
                .description("¡La impresión 3D es una auténtica revolución en la manera de fabricar! Con esta impresora Artillery Genius vas a poder realizar réplicas de tus diseños tridimensionales y ver cómo cobran vida.")
                .stock(3)
                .price(BigDecimal.valueOf(74999))
                .category(categoryMock.getDefaultComplete())
                .build();
    }

    public Product getOneComplete() {
        return Product.builder()
                .id(1L)
                .name("Impresora 3D Artillery Genius")
                .description("¡La impresión 3D es una auténtica revolución en la manera de fabricar! Con esta impresora Artillery Genius vas a poder realizar réplicas de tus diseños tridimensionales y ver cómo cobran vida.")
                .stock(3)
                .price(BigDecimal.valueOf(74999))
                .category(categoryMock.getDefaultComplete())
                .build();
    }

    public List<Product> getBasicList() {
        return List.of(
                Product.builder()
                        .name("Impresora 3D Artillery Genius")
                        .description("¡La impresión 3D es una auténtica revolución en la manera de fabricar! Con esta impresora Artillery Genius vas a poder realizar réplicas de tus diseños tridimensionales y ver cómo cobran vida.")
                        .stock(3)
                        .price(BigDecimal.valueOf(74999))
                        .category(categoryMock.getDefaultComplete())
                        .build(),
                Product.builder()
                        .name("Sony PlayStation 3 Slim 160GB Standard  color charcoal black")
                        .description("Con tu consola PlayStation 3 tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.")
                        .stock(71)
                        .price(BigDecimal.valueOf(40000))
                        .category(categoryMock.getDefaultComplete())
                        .build()
        );
    }

    public List<Product> getCompleteListDefaultCategory() {
        return List.of(
                Product.builder()
                        .id(1L)
                        .name("Impresora 3D Artillery Genius")
                        .description("¡La impresión 3D es una auténtica revolución en la manera de fabricar! Con esta impresora Artillery Genius vas a poder realizar réplicas de tus diseños tridimensionales y ver cómo cobran vida.")
                        .stock(3)
                        .price(BigDecimal.valueOf(74999))
                        .category(categoryMock.getDefaultComplete())
                        .build(),
                Product.builder()
                        .id(2L)
                        .name("Sony PlayStation 3 Slim 160GB Standard  color charcoal black")
                        .description("Con tu consola PlayStation 3 tendrás entretenimiento asegurado todos los días. Su tecnología fue creada para poner nuevos retos tanto a jugadores principiantes como expertos.")
                        .stock(71)
                        .price(BigDecimal.valueOf(40000))
                        .category(categoryMock.getDefaultComplete())
                        .build()
        );
    }
}
