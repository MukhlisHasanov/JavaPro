package app.repository;

import app.entity.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Long, Product> map = new HashMap<>();
    static {
        map.put(1L, new Product(1L, "Milk", new BigDecimal("1.79"), "12345" ));
        map.put(1L, new Product(1L, "Kefir", new BigDecimal("1.79"), "12345" ));
        map.put(1L, new Product(1L, "Butter", new BigDecimal("1.79"), "12345" ));
    }


    @Override
    public List<Product> findAll() {
        return map
                .values()
                .stream()
                .toList();
    }

    @Override
    public Product save(Product product) {
        return null;
    }
}
