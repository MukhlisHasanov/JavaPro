package de.ait.shop42.product.repository;

import de.ait.shop42.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByActive(boolean active);
    List<Product> findProductsByTitle(String title);
    List<Product> findByTitleAndActive(String title, boolean active);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByTitleIn(List<String> titles);


}
