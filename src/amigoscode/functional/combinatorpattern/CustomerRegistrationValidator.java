package amigoscode.functional.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static amigoscode.functional.combinatorpattern.CustomerRegistrationValidator.*;
import static amigoscode.functional.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID ;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID ;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> isAdult(customer) ? SUCCESS : IS_NOT_AN_ADULT ;
    }

    static boolean isAdult(Customer customer) {
        return Period.between(customer.getDob(), LocalDate.now()).getYears() > 18;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult validationResult = this.apply(customer);
            return validationResult == SUCCESS ? other.apply(customer) : validationResult;
        };
    }

    enum ValidationResult {
        SUCCESS("Success"),
        PHONE_NUMBER_NOT_VALID("Phone number is not valid"),
        EMAIL_NOT_VALID("Email is not valid"),
        IS_NOT_AN_ADULT("Person is not an adult");

        private String description;

        ValidationResult(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
