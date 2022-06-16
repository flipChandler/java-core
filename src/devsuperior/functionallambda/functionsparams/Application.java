package devsuperior.functionallambda.functionsparams;

import devsuperior.functionallambda.comparator.Product;
import devsuperior.functionallambda.functionsparams.service.ProductService;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        var list = new ArrayList<Product>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));

        var productService = new ProductService();
        var sum = productService.filteredSum(list,
                product -> product.getName().charAt(0) == 'T');     // passing a predicate of product

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
