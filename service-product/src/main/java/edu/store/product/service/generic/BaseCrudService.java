package edu.store.product.service.generic;

import edu.store.product.domain.model.BaseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import static java.util.Objects.isNull;

public abstract class BaseCrudService <T extends BaseEntity, ID extends Serializable> implements BaseCrud <T, ID> {

    protected JpaRepository<T, ID> repository;

    public T save(T entity) {
        if(isNull(entity.getId())){
            entity.setCreationDate(new Date());
        }
        entity.setModifyDate(new Date());
        return repository.save(entity);
    }

    public void remove(ID id) {
        repository.deleteById(id);
    }

    public void toggleEnabled(ID id) {
        T entity = findById(id);
        Optional.ofNullable(findById(id))
                .orElseThrow(() -> new RuntimeException("Entity not found"));   // TODO: custom exceptions
        save(entity);
    }

    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<T> findAll() {
        return repository.findAll(defaultSorting());
    }

    private Sort defaultSorting() {
        return Sort.by("modifyDate").descending();
    }

    protected void setRepository(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
}
