package de.ait;

import app.entity.Product;

import java.util.List;


/** task #2
 * Допустим у вас дан List<Product> (класс Product реализован на занятии),
 * необходимо написать метод, который вернет product по-заданному id.
 * Используйте Stream Api
 */
public class FindById {

        public Product findProductById(List<Product> products, Long id) {
            return products.stream()
                    .filter(product -> product.getId() == id)
                    .findFirst()
                    .orElse(null);  // Возвращаем null, если продукт не найден
        }
    }
