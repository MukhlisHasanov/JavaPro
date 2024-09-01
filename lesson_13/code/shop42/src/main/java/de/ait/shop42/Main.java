package de.ait.shop42;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.entity.Product;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ProductRequestDTO dto= new ProductRequestDTO("Milk", new BigDecimal("1.98"));
        ModelMapper mapper = new ModelMapper();

        Product p = mapper.map(dto, Product.class);
        System.out.println(p);
    }
}
