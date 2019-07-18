package com.ilkiv.service;

import com.ilkiv.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAllById(Long id);
}
