package com.ilkiv.service;

import com.ilkiv.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<Category>> getAll();

    Optional<Category> getById(Long id);

    Optional<Category> create(Category category);

    Optional<Category> update(Category category);

    void delete(Long id);
}
