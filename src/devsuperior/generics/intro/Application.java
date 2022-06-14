package devsuperior.generics.intro;

import devsuperior.generics.intro.services.PrintService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var printService = new PrintService<String>();

        System.out.println("How many values?");
        var times = scanner.nextInt();

        for (var i = 0; i < times; i++) {
            var value = scanner.next();
            printService.addValue(value);
        }

        printService.print();

        System.out.println("First: " + printService.first());

        scanner.close();
    }
}
