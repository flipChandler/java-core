package devsuperior.generics.curingadelimitados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationSpecificToGeneric {

    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjects = new ArrayList<>();

        copy(myInts, myObjects);
        printList(myObjects);

        copy(myDoubles, myObjects);
        printList(myObjects);
    }

    // covariancia: List<? extends Number> source
    // contravariancia: List<? super Number> target
    private static void copy(List<? extends Number> source, List<? super Number> target) {
        for (Number number : source) {
            target.add(number);
        }
    }

    public static void printList(List<?> list) {
        list.forEach(obj -> System.out.print(obj + " "));
        System.out.println();
    }
}
