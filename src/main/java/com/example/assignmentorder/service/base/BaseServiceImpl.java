package com.example.assignmentorder.service.base;

import com.example.assignmentorder.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl <E,Id, R extends BaseRepository<E, Id>> implements BaseService<E, Id> {

    private R repository;

    public BaseServiceImpl(R r){
        this.repository = r;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<E> findById(Id id) {
        return repository.findById(id);
    }

    @Override
    public E create(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.save(e);
    }

    @Override
    public void delete(E e) {
        repository.delete(e);
    }
}
