package app.repository;

import app.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Long, Product> map = new HashMap<>();
    static {
        map.put(1L, new Product(1L, "Milk", new BigDecimal("1.79"), "12345-i" ));
        map.put(2L, new Product(2L, "Kefir", new BigDecimal("1.39"), "12346-i" ));
        map.put(3L, new Product(3L, "Butter", new BigDecimal("1.56"), "12347-i" ));
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
