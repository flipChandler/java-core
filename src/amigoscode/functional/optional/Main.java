package amigoscode.functional.optional;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "default value";

        Object value = Optional.ofNullable("Ola")
                .orElseGet(stringSupplier);

        System.out.println(value);

        Optional.ofNullable("Ola")
                .ifPresent(System.out::println);

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        Main::sendEmail,
                        Main::orElse);
    }

    private static void sendEmail(Object email) {
        System.out.println("sending email to " + email);
    }

    private static void orElse() {
        System.out.println("cannot send email");
    }
}
