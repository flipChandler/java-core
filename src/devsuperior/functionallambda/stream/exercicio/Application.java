package devsuperior.functionallambda.stream.exercicio;

import devsuperior.functionallambda.comparator.Product;
import devsuperior.generics.delimitados.service.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        var path = "/home/felipe/Documents/cursos/dev-superior/ws-java-8/java-8/src/devsuperior/products.txt";

        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            var list = new ArrayList<Product>();
            var line = bufferedReader.readLine();

            while (line != null) {
                var fields = line.split(",");
                list.add(new Product(fields[0], parseDouble(fields[1])));
                line = bufferedReader.readLine();
            }

            var avg = list.stream()
                    .map(product -> product.getPrice())
                    .reduce(0.0, (x, y) -> x + y) / list.size();

            var comparator =(Comparator<String>) (param1, param2) -> param1.toUpperCase()
                    .compareTo(param2.toUpperCase());

            var names = list.stream()
                    .filter(product -> product.getPrice() < avg)
                    .map(product -> product.getName())
                    .sorted(comparator.reversed())
                    .collect(Collectors.toList());

            System.out.println("Average price: " + String.format("%.2f", avg));
            names.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
