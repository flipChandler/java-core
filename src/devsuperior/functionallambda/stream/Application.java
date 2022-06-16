package devsuperior.functionallambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4};

        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(System.out::println);

        var list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> stream1 = list.stream();
        System.out.println(Arrays.toString(stream1.toArray()));

        list.stream()
                .map(numero -> numero * 10)
                .forEach(numero -> System.out.print(numero + " "));
        System.out.println();

        Stream<String> streamString = Stream.of("Maria", "Brad", "Milla");
        System.out.println(Arrays.toString(streamString.toArray()));

        List<Integer> intList = Stream.iterate(0, numero -> numero + 2)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(intList);

        // fibonnaci sequence
        Stream<Long> longStream = Stream.iterate(
                new Long[] {0L, 1L}, numero -> new Long[] {numero[1], numero[0] + numero[1]})
                .map(numero -> numero[0]);

        System.out.println(
                Arrays.toString(longStream
                        .limit(10)
                        .toArray()));
    }
}

// intermediate operations -> filter, map, flatmap, peek, distinct, sorted, skip, limit

// terminal operations -> forEach, forEachOrdered, toArray, reduce, collect, min, max, count, anyMatch,
// noneMatch, findFirst, findAny

// ways to create a stream
// Stream.of, Stream.ofNullable, Stream.iterate