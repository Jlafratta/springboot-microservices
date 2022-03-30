package edu.store.product.controller;

import edu.store.product.controller.generic.CrudResponse;
import edu.store.product.controller.generic.GenericController;
import edu.store.product.domain.dto.RestResponse;
import edu.store.product.domain.model.Category;
import edu.store.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/category")
public class CategoryController extends GenericController<Category, Long> {

    @Autowired
    public CategoryController(CategoryService categoryService) {
        setService(categoryService);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @GetMapping
    public ResponseEntity<RestResponse> findAll() {
        return super.findAll();
    }

    @PostMapping
    public ResponseEntity<RestResponse> save(@RequestBody Category category) {
        return super.save(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse> remove(@PathVariable Long id) {
        return super.remove(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse> toggleEnabled(@PathVariable Long id) {
        return super.toggleEnabled(id);
    }

    @Override
    protected URI getLocation(Category entity) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/category/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }
}
