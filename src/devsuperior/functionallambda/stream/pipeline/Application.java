package devsuperior.functionallambda.stream.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> intStream = list.stream()
                .map(numero -> numero * 10);    // intermediate operation

        System.out.println(Arrays.toString(intStream.toArray()));   // terminal operation

        int sum = list.stream()
                .reduce(0, (x, y) -> x + y);    // terminal operation

        System.out.println(sum);

        int product = list.stream()
                .reduce(1, (x, y) -> x * y);

        System.out.println(product);

        List<Integer> newList = list.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 10)
                .collect(Collectors.toList());

        System.out.println(newList);
    }
}
