package devsuperior.interfaces.comparable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Application {

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        var path = "/home/felipe/Documents/cursos/dev-superior/ws-java-8/java-8/src/devsuperior/in.txt";

        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            var name = bufferedReader.readLine();
            while (name != null) {
                list.add(name);                         // add name
                name = bufferedReader.readLine();       // le a proxima linha
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
