package amigoscode.functional.finalsection;

import java.util.function.Consumer;

public class Callbacks {

    public static void main(String[] args) {

        // Consumer
        hello("John", null, checkLastName -> {
            System.out.println("no lastName provided for " + checkLastName);
        });

        // Runnable
        hello("John",
                null,
                () -> System.out.println("no lastName provided for "));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}

// function hello(firstName, lastName, callback) {
//      console.log(firstName);
//      if (lastName) {
//          console.log(lastName)
//      } else {
//          callback()
//      }
// }