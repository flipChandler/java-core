package amigoscode.functional.combinatorpattern;

import java.time.LocalDate;
import java.util.Optional;

import static  amigoscode.functional.combinatorpattern.CustomerRegistrationValidator.*;
import static amigoscode.functional.combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+003893883993",
                LocalDate.of(2002, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer)); // false | we don't know what it is wrong in customer

        // using combinator pattern
        ValidationResult validationResult = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(validationResult.getDescription());

        Optional.of(validationResult)
                .ifPresent(result -> {
                    if (result != SUCCESS) {
                        throw new IllegalStateException(result.getDescription());
                    }
                    System.out.println(SUCCESS.getDescription());
                });
    }
}
