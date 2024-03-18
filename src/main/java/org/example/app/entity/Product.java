package org.example.app.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Product {
    private Long id;
    private String name;
    private int quota;
    private double price;

    public Product() {

    }
    public Product(String name, int quota, double price) {
        this.name = name;
        this.quota = quota;
        this.price = price;
    }

    public Product(Long id, String name, int quota, double price) {
        this.id = id;
        this.name = name;
        this.quota = quota;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuota() {
        return quota;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id - " + this.getId() +
                ", " + this.getName() +
                " " + this.quota +
                ", price: " + this.getPrice() + "\n";
    }
}

