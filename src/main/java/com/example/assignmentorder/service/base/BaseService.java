package com.example.assignmentorder.service.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<E, ID> {

    List<E> findAll();

    Optional<E> findById(ID id);

    E create(E e);

    E update(E e);

    void delete(E e);
}
