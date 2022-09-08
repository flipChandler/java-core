package amigoscode.functional.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;

import static amigoscode.functional.stream._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> person.gender == FEMALE);
        System.out.println(containsOnlyFemales);    // false

        boolean containsFemales = people.stream()
                .anyMatch(person -> person.gender == FEMALE);
        System.out.println(containsFemales);    // true

        boolean doesNotContainPreferNotToSay = people.stream()
                .noneMatch(person -> person.gender == PREFER_NOT_TO_SAY);
        System.out.println(doesNotContainPreferNotToSay);    // true
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
