package devsuperior.functionallambda.function;

import devsuperior.functionallambda.comparator.Product;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var products = new ArrayList<Product>();

        products.add(new Product("TV",900.0));
        products.add(new Product("Mouse",50.0));
        products.add(new Product("Tablet",350.0));
        products.add(new Product("HD Case",80.90));

        // versao 1
        var names = products.stream()
                .map(product -> product.getName().toUpperCase())
                .collect(Collectors.toSet());
        System.out.println(names);

        // versao 2
        var names2 = products.stream()
                .map(new UpperCaseName())
                .collect(Collectors.toList());

        System.out.println(names2);

        // versao 3
        var function3 = (Function<Product, String>) product -> product.getName().toUpperCase();

        var names3 = products.stream()
                .map(function3)
                .collect(Collectors.toList());

        System.out.println(names3);

        // versao 4
        var names4 = products.stream()
                .map(Product::staticUpperCaseName)
                .collect(Collectors.toList());

        System.out.println(names4);

        // versao 5
        var names5 = products.stream()
                .map(Product::nonStaticUpperCaseName)
                .collect(Collectors.toList());

        System.out.println(names5);

        // versao 6
        Function function6 = new Function<Product, String>() {
            @Override
            public String apply(Product product) {
                return product.getName().toUpperCase();
            }
        };

        var names6 = products.stream()
                .map(function6)
                .collect(Collectors.toList());

        System.out.println(names6);
    }
}
