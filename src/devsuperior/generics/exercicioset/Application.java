package devsuperior.generics.exercicioset;

import devsuperior.generics.exercicioset.model.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        var path = scanner.nextLine();

        try (var bufferedReader = new BufferedReader(new FileReader(path))) {
            var set = new HashSet<LogEntry>();

            var line = bufferedReader.readLine();
            while (line != null) {
                var fields = line.split(" ");
                var username = fields[0];
                var moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(username, moment));
                line = bufferedReader.readLine();
            }
            System.out.println("Total users: " + set.size());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
