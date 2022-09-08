package amigoscode.functional.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static amigoscode.functional.imperative.Main.Gender.FEMALE;
import static amigoscode.functional.imperative.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );

        // imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.gender == FEMALE) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // declarative approach
        Predicate<Person> personPredicate = person -> person.gender == FEMALE;
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
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
        FEMALE
    }
}
