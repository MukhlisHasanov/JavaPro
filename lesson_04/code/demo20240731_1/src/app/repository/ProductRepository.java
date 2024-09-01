package app.repository;

import app.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
    public List<Product> findAll();
    public Product save(Product product);



}
