package de.ait;

import app.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** task #4
 * 4. Допустим у вас дан List<Product> (класс Product реализован на занятии),
 * необходимо написать метод, который вернет Map<Long,Product> (ключ id, значение product)
 * содержащий все продукты в название которых есть заданная подстрока.
 */

public class FilterProductsByTitleSubstring {
    public Map<Long, Product> filterProductsByTitleSubstring(List<Product> products, String substring) {
        return products.stream()
                .filter(product -> product.getTitle().contains(substring))
                .collect(Collectors.toMap(Product::getId, product -> product));
    }
}
