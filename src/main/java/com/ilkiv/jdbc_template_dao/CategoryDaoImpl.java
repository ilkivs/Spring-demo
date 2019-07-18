package com.ilkiv.jdbc_template_dao;

import com.ilkiv.jdbc_template_dao.templates.CategoryJdbcTemplate;
import com.ilkiv.model.Category;

import java.util.List;
import java.util.Optional;

//@Repository
public class CategoryDaoImpl implements CategoryDao {

    //@Autowired
    private CategoryJdbcTemplate jdbcTemplate;

    @Override
    public Optional<List<Category>> getAll() {
        return jdbcTemplate.getAll();
    }

    @Override
    public Optional<Category> create(Category category) {
        return jdbcTemplate.create(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        return jdbcTemplate.getById(id);
    }

    @Override
    public Optional<Category> update(Category category) {
        return jdbcTemplate.update(category);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.delete(id);
    }
}
