package devsuperior.generics.delimitados;

import devsuperior.generics.delimitados.model.Product;
import devsuperior.generics.delimitados.service.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ApplicationProduct {

    public static void main(String[] args) {
        var list = new ArrayList<Product>();
        var path = "/home/felipe/Documents/cursos/dev-superior/ws-java-8/java-8/src/products.txt";

        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            var line = bufferedReader.readLine();

            while (line != null) {
                var fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = bufferedReader.readLine();
            }

            var maxValue = CalculationService.max(list);
            System.out.print("Max: ");
            System.out.println(maxValue);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
