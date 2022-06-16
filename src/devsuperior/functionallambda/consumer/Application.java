package devsuperior.functionallambda.consumer;

import devsuperior.functionallambda.comparator.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        var products = new ArrayList<Product>();

        products.add(new Product("TV",900.0));
        products.add(new Product("Mouse",50.0));
        products.add(new Product("Tablet",350.0));
        products.add(new Product("HD Case",80.90));

        // versao 1
        products.forEach(product -> product.setPrice(product.getPrice() * 2));
        products.forEach(System.out::println);

        // versao 2
        products.forEach(new PriceUpdate());
        System.out.println(products);

        // versao 3
        products.forEach(Product::staticPriceUpdate);
        System.out.println(products);

        // versao 4
        products.forEach(Product::nonStaticPriceUpdate);
        System.out.println(products);

        // versao 5
        Consumer consumer = new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                product.setPrice(product.getPrice() * 2);
            }
        };

        products.forEach(consumer);
        System.out.println(products);
    }
}
