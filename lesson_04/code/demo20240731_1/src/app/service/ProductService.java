package app.service;

import app.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);
}
