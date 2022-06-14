package devsuperior.generics.intro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.function.Predicate.not;

public class PrintService<T> {

    List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {

        return Optional.ofNullable(list)
                .filter(not(List::isEmpty))
                .map(value -> value.get(0))
                .orElseThrow(() -> new IllegalStateException("List is empty"));
    }

    public void print() {
        System.out.println(list);
    }
}
