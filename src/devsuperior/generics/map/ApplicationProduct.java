package devsuperior.generics.map;

import devsuperior.generics.delimitados.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ApplicationProduct {

    public static void main(String[] args) {

        Map<Product, Double> stock = new HashMap<>();
         var product1 = new Product("TV", 900.0);
         var product2 = new Product("Notebook", 1200.0);
         var product3 = new Product("Tablet", 400.0);

         stock.put(product1, 10000.0);
         stock.put(product2, 20000.0);
         stock.put(product3, 15000.0);

         var product4 = new Product("TV", 900.0);

        System.out.println("Contains 'ps' key: " + stock.containsKey(product4));
    }
}
