package devsuperior.functionallambda.comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Application {

    public static int compareProducts(Product product, Product otherProduct) {
        return product.getPrice().compareTo(otherProduct.getPrice());
    }

    public static void main(String[] args) {
        var list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        // versao 1
        list.sort(new MyComparator());
        list.forEach(System.out::println);

        // versao 2
        var comparator2 = new Comparator<Product>() {
            @Override
            public int compare(Product product, Product otherProduct) {
                return product.getName().toUpperCase()
                        .compareTo(otherProduct.getName().toUpperCase());
            }
        };

        list.sort(comparator2);
        list.forEach(System.out::println);

        // versao 3
        Comparator<Product> comparator3 = (product, otherProduct) -> {
            return product.getName().toUpperCase()
                    .compareTo(otherProduct.getName().toUpperCase());
        };

        list.sort(comparator3);
        list.forEach(System.out::println);

        // versao 4
        Comparator<Product> comparator4 =
                (product, otherProduct) ->
                        product.getName().toUpperCase()
                                .compareTo(
                                        otherProduct.getName().toUpperCase());

        list.sort(comparator4);
        list.forEach(System.out::println);

        // versao 5
        list.sort(Application::compareProducts);    // a function receiving another function
        list.forEach(System.out::println);

        // versao 6
        list.sort((product, otherProduct) ->
             product.getName().toUpperCase()
                    .compareTo(otherProduct.getName().toUpperCase()));

        list.forEach(System.out::println);
    }
}
