package edu.store.product.controller.generic;

import edu.store.product.domain.dto.RestResponse;
import edu.store.product.domain.model.BaseEntity;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface CrudResponse <T extends BaseEntity, ID extends Serializable> {
    ResponseEntity<RestResponse> findById(ID id);
    ResponseEntity<RestResponse> findAll();
    ResponseEntity<RestResponse> save(T entity);
    ResponseEntity<RestResponse> remove(ID id);
    ResponseEntity<RestResponse> toggleEnabled(ID id);
    ResponseEntity<RestResponse> success(Object data);
    ResponseEntity<RestResponse> success();
}
