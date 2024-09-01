package de.ait;

import app.entity.Product;

import java.util.List;

/** task #3
 * 3. Допустим у вас дан List<Product> (класс Product реализован на занятии),
 * необходимо написать метод, который вернет наибольший id в списке.
 */

public class FindMaxIdInList {
    public Long findMaxId(List<Product> products) {
        return products.stream()
                .map(Product::getId)
                .max(Long::compareTo)
                .orElse(null);
    }
}