package devsuperior.generics.set;

import java.util.HashSet;

public class Application {

    public static void main(String[] args) {
        var set = new HashSet<String>();        // faster, O(1) using hash table and non-ordered
        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");
        set.add("TV");
        set.add("Tablet");

        set.remove("Tablet");
        set.removeIf(elemento -> elemento.length() > 4);
        set.removeIf(elemento -> elemento.charAt(0) == 'T');

        System.out.println(set.contains("Notebook"));

        set.forEach(System.out::println);
    }
}
