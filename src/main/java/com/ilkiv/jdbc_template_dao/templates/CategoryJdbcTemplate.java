package com.ilkiv.jdbc_template_dao.templates;

import com.ilkiv.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Types.BIGINT;

//@Component
public class CategoryJdbcTemplate {

    //@Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<List<Category>> getAll() {
        String query = "SELECT ID, NAME, DESCRIPTION FROM CATEGORY";
        List<Category> categories = jdbcTemplate.query(query, (ResultSet rs, int columnNumber) ->
                new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3)));
        return Optional.ofNullable(categories);
    }

    public Optional<Category> create(Category category) {
        String query = "INSERT INTO CATEGORY VALUES (?, ?, ?)";
        jdbcTemplate.execute(query, (PreparedStatementCallback<Category>) ps -> {
            ps.setNull(1, BIGINT);
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.execute();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                category.setId(keys.getLong(1));
                return category;
            } else {
                return null;
            }
        });
        return Optional.ofNullable(category);
    }

    public Optional<Category> getById(Long id) {
        String query = "SELECT ID, NAME, DESCRIPTION FROM CATEGORY WHERE ID = ?";
        Category category = jdbcTemplate.execute(query, (PreparedStatementCallback<Category>) ps -> {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3));
            } else {
                return null;
            }
        });
        return Optional.ofNullable(category);
    }

    public Optional<Category> update(Category category) {
        String query = "UPDATE CATEGORY SET NAME=?, DESCRIPTION=? WHERE ID = ?";
        jdbcTemplate.update(query, ps -> {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            ps.setLong(3, category.getId());
            ps.executeUpdate();
        });
        //TODO fix this
        return Optional.ofNullable(category);
    }

    public void delete(Long id) {
        String query = "DELETE FROM CATEGORY WHERE ID = ?";
        jdbcTemplate.update(query, ps -> {
            ps.setLong(1, id);
            ps.executeUpdate();
        });
    }
}