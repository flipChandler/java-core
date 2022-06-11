package devsuperior.interfaces.comparable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ApplicationEmployee {

    public static void main(String[] args) {
        var list = new ArrayList<Employee>();
        var path = "/home/felipe/Documents/cursos/dev-superior/ws-java-8/java-8/src/employee.txt";

        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            var employeeCsv = bufferedReader.readLine();

            while (employeeCsv != null) {
                var fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));     // add name
                employeeCsv = bufferedReader.readLine();                              // le a proxima linha
            }

            Collections.sort(list);
            list.forEach(employee -> System.out.println(employee.getName() + ", " + employee.getSalary()));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
