package devsuperior.generics.curinga;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var myInts = Arrays.asList(1, 7, 10);
        // myInts.add(23); can't set values in wildcard lists, throws 'UnsupportedOperationException'
        printList(myInts);

        var myStrings = List.of("Jacob", "Kalel", "Bruce");
        printList(myStrings);
    }

    private static void printList(List<?> list) {
        list.forEach(System.out::println);
    }
}
