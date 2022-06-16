package devsuperior.generics.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationSet {

    public static void main(String[] args) {
        Set<Integer> setA = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
        Set<Integer> setB = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        // union
        Set<Integer> setC = new TreeSet<>(setA);
        setC.addAll(setB);
        System.out.println(setC);       // [0, 2, 4, 5, 6, 7, 8, 9, 10]

        Set<Integer> setC2 = Stream.of(setB, setC)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        System.out.println(setC2);       // [0, 2, 4, 5, 6, 7, 8, 9, 10]

        // intersection
        Set<Integer> setD = new TreeSet<>(setA);
        setD.retainAll(setB);
        System.out.println(setD);      // [5, 6, 8, 10]

        Set<Integer> setD2 = setA.stream()
                .filter(value -> setB.contains(value))
                .collect(Collectors.toSet());
        System.out.println(setD2);      // [5, 6, 8, 10]

        // difference
        Set<Integer> setE = new TreeSet<>(setA);
        setE.removeAll(setB);
        System.out.println(setE);      // [0, 2, 4]

        Set<Integer> setE2 = setA.stream()
                .filter(value -> !setB.contains(value))
                .collect(Collectors.toSet());
        System.out.println(setE2);      // [0, 2, 4]
    }
}
