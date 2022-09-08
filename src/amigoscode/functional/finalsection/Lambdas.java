package amigoscode.functional.finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        // 1
        Function<String, String> upperCaseName = name -> {
            if (name.isBlank()) {
                throw new IllegalStateException("should not be blank");
            }
            return name.toUpperCase();
        };

        System.out.println(upperCaseName.apply("felipe"));

        // 2
        Function<String, String> upperCaseNameMethodReference = String::toUpperCase;

        System.out.println(upperCaseNameMethodReference.apply("chris cornell"));

        // 3
        BiFunction<String, Integer, String> upperCaseNameAndAge = (name, age) -> {
            if (name.isBlank()) {
                throw new IllegalStateException("should not be blank");
            }
            return name.toUpperCase() + ", " + age;
        };

        System.out.println(upperCaseNameAndAge.apply("nearly forgot", 35));
    }
}
