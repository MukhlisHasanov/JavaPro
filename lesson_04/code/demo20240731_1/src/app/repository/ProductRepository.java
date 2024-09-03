package app.repository;

import app.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
    List<Product> findAll();
    Product save(Product product);



}
