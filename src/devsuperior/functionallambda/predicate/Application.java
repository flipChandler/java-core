package devsuperior.functionallambda.predicate;

import devsuperior.functionallambda.comparator.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        var products = new ArrayList<Product>();

        products.add(new Product("TV",900.0));
        products.add(new Product("Mouse",50.0));
        products.add(new Product("Tablet",350.0));
        products.add(new Product("HD Case",80.90));

        // versao 1
        products.removeIf(product -> product.getPrice() >= 100);
        products.forEach(System.out::println);

        // versao 2
        products.removeIf(new ProductPredicate());
        products.forEach(System.out::println);

        // versao 3
        products.removeIf(Product::staticProductPredicate);
        products.forEach(System.out::println);

        // versao 4
        products.removeIf(Product::nonStaticProductPredicate);
        products.forEach(System.out::println);

        // versao 5
        var predicate5 = (Predicate<Product>) product -> product.getPrice() >= 100;
        products.removeIf(predicate5);

        // versao 6
        Predicate predicate = new Predicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() >= 100;
            }
        };
        products.removeIf(predicate);
        products.forEach(System.out::println);
    }
}
