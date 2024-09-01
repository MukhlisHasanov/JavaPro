package de.ait;

import app.entity.Product;

import java.util.List;

public class FindMaxIdInList {
    public Long findMaxId(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                .max(Long::compareTo)
                .orElse(null);
    }
}