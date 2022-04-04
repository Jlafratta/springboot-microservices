package edu.store.product.controller;

import edu.store.product.controller.generic.CrudResponse;
import edu.store.product.controller.generic.GenericController;
import edu.store.product.domain.dto.RestResponse;
import edu.store.product.domain.model.Product;
import edu.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericController<Product, Long> {

    @Autowired
    public ProductController(ProductService service) {
        setService(service);
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
    public ResponseEntity<RestResponse> save(@RequestBody Product product) {
        return super.save(product);
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
    protected URI getLocation(Product entity) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/product/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}
