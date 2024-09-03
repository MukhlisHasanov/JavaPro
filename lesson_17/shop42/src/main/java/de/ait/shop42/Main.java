package de.ait.shop42;

import de.ait.shop42.cart.entity.Cart;
import de.ait.shop42.customer.entity.Customer;
import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        /*
        Customer customer = new Customer(1L, "Jack", true, null);
        Cart cart = new Cart(1L, customer, null);
        customer.setCart(cart);

        System.out.println(customer);
        */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "qwerty";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);

        String encodedPassword2 = encoder.encode(password);
        System.out.println(encodedPassword2);


    }
}
