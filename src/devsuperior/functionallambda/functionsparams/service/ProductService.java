package devsuperior.functionallambda.functionsparams.service;

import devsuperior.functionallambda.comparator.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> list, Predicate<Product> predicate) {
        var sum = 0.0;
        for (var product : list) {
            if (predicate.test(product)) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
}
