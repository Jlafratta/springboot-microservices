package edu.store.product.controller.generic;

import edu.store.product.domain.dto.RestResponse;
import edu.store.product.domain.model.BaseEntity;
import edu.store.product.service.generic.BaseCrudService;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.net.URI;

import static java.util.Objects.isNull;

@Setter
public abstract class GenericController <T extends BaseEntity, ID extends Serializable> implements CrudResponse <T, ID> {

    protected BaseCrudService<T, ID> service;

    @Override
    public ResponseEntity<RestResponse> success(Object data) {
        return ResponseEntity.ok(
                RestResponse.builder()
                        .data(data)
                        .build());
    }

    @Override
    public ResponseEntity<RestResponse> success() {
        return ResponseEntity.ok(RestResponse.builder().build());
    }

    @Override
    public ResponseEntity<RestResponse> findById(ID id) {
        T entity = service.findById(id);
        return !isNull(entity) ? success(entity) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<RestResponse> findAll() {
        Iterable<T> entityList = service.findAll();
        return entityList.iterator().hasNext() ? success(entityList) : ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<RestResponse> save(T entity) {
        T savedEntity = service.save(entity);
        return ResponseEntity.created(getLocation(savedEntity)).build();
    }

    @Override
    public ResponseEntity<RestResponse> remove(ID id) {
        service.remove(id);
        return success();
    }

    @Override
    public ResponseEntity<RestResponse> toggleEnabled(ID id) {
        service.toggleEnabled(id);
        return success();
    }

    protected abstract URI getLocation(T entity);
}
