package edu.store.product.repository;

import edu.store.product.domain.model.Category;
import edu.store.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}