package edu.store.product.service.generic;

import edu.store.product.domain.model.BaseEntity;

import java.io.Serializable;

public interface BaseCrud<T extends BaseEntity, ID extends Serializable> {

    T findById(ID id);
    Iterable<T> findAll();
    T save(T entity);
    void remove(ID id);
    void toggleEnabled(ID id);
}
