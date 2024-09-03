package de.ait.shop42.cart.dto;

import de.ait.shop42.cart.entity.Cart;
import de.ait.shop42.product.dto.ProductResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartResponseDto {
    private Long id;
    private List<ProductResponseDTO> products;
}
