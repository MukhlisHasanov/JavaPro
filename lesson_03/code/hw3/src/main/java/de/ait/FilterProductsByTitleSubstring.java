package de.ait;

import app.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterProductsByTitleSubstring {
    public Map<Long, Product> filterProductsByTitleSubstring(List<Product> products, String substring) {
        return products.stream()
                .filter(product -> product.getTitle().contains(substring))
                .collect(Collectors.toMap(Product::getId, product -> product));
    }
}
