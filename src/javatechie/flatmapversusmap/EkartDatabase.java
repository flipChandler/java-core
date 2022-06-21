package javatechie.flatmapversusmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDatabase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("4521225452", "1427845250")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("45243200545", "8733330970")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("4223212254009", "5455602290")),
                new Customer(104, "kelly", "kelly@gmail.com", Arrays.asList("450022545277", "91245145250"))
        ).collect(Collectors.toList());
    }
}
