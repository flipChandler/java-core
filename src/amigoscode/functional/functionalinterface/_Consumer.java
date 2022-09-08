package amigoscode.functional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    // Consumer :: accept -> take a argument and returns void
    public static void main(String[] args) {
        var customer = new Customer("Maria","9999999");
        greetCustomer(customer);
        greetCostumerByConsumer.accept(customer);

        greetCustomer(customer, false);
        greetCostumerByBiConsumer.accept(customer, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.name
                + ", thanks for registering phone number "
                + customer.phoneNumber);
    }

    static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.name
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.phoneNumber : "*************"));
    }

    static Consumer<Customer> greetCostumerByConsumer = customer ->
            System.out.println("Hello " + customer.name
                    + ", thanks for registering phone number "
                    + customer.phoneNumber);

    static BiConsumer<Customer, Boolean> greetCostumerByBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.name
                    + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.phoneNumber : "*************"));

    static class Customer {
        private final String name;
        private final String phoneNumber;

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
