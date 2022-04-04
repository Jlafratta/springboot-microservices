package edu.store.product.service.mock;

import edu.store.product.domain.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMock {

    public Category getOneBasic() {
        return Category.builder()
                .name("New")
                .build();
    }

    public Category getDefaultComplete() {
        return Category.builder()
                .id(1L)
                .name("New")
                .build();
    }

    public List<Category> getBasicList() {
        return List.of(
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
    }

    public List<Category> getCompleteList() {
        return List.of(
                Category.builder()
                        .id(1L)
                        .name("New")
                        .build(),
                Category.builder()
                        .id(2L)
                        .name("Star")
                        .build(),
                Category.builder()
                        .id(3L)
                        .name("Season")
                        .build(),
                Category.builder()
                        .name("Supporter")
                        .id(4L)
                        .build(),
                Category.builder()
                        .name("Downward")
                        .id(5L)
                        .build()
        );
    }
}
