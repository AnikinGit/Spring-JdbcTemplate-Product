package org.example.app.repository.impl;

import org.example.app.entity.Product;
import org.example.app.entity.ProductMapper;
import org.example.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository implements AppRepository<Product> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Product product) {
        String sql = "INSERT INTO products (name, quota, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, product.getName(), product.getQuota(), product.getPrice()) > 0;
    }

    @Override
    public Optional<List<Product>> fetchAll() {
        String sql = "SELECT * FROM products";
        List<Product> productList = jdbcTemplate.query(sql, new ProductMapper());
        return productList.isEmpty() ? Optional.empty() : Optional.of(productList);
    }

    @Override
    public Optional<Product> fetchById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> productList = jdbcTemplate.query(sql, new ProductMapper(), id);
        return productList.isEmpty() ? Optional.empty() : Optional.of(productList.get(0));
    }

    @Override
    public boolean update(Product product) {
        String sql = "UPDATE products SET name = ?, quota = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getName(), product.getQuota(), product.getPrice(), product.getId()) > 0;
    }

    @Override
    public boolean delete(Product product) {
        String sql = "DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql, product.getId()) > 0;
    }
}

