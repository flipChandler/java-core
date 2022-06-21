package devdojo.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApplicationNumberStream {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 50)
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> System.out.print(numero + " ")); // 1 .. 50

        System.out.println();

        IntStream.range(1, 50)
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> System.out.print(numero + " ")); // 1 .. 48

        System.out.println();

        int numeros[] = {20, 34, 56, 3, 12};
        OptionalDouble average = Arrays.stream(numeros).average();
        System.out.println(average.getAsDouble());  // 25.0

        Stream.iterate(1, numero -> numero + 2)
                .limit(10)
                .forEach(numero -> System.out.print(numero + " ")); // 1 .. 19

        System.out.println();

        Stream.iterate(new int[] {0, 1}, numero -> new int[] {numero[1], numero[0] + numero[1]})
                .limit(5)
                .forEach(numero -> System.out.print(Arrays.toString(numero) + " ")); // [0, 1] [1, 1] [1, 2] [2, 3] [3, 5]

        System.out.println();

        Stream.iterate(new int[] {0, 1}, numero -> new int[] {numero[1], numero[0] + numero[1]})
                .limit(5)
                .map(numero -> numero[0])
                .forEach(numero -> System.out.print(numero + " ")); // 0 1 1 2 3

        System.out.println();

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println); // random numbers like 0.30037700702857484

        System.out.println();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Stream.generate(() -> threadLocalRandom.nextInt(0, 101)) // random numbers between 0 & 100
                .limit(100)
                .forEach(numero -> System.out.print(numero + " "));
    }
}
