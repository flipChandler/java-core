package javatechie.flatmapversusmap;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Customer> customers = EkartDatabase.getAll();

        // customer -> customer.getEmail()  one-to-one mapping
        List<String> emails = customers.stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());
        System.out.println(emails);

        // customer -> customer.getPhoneNumbers()   one-to-many mapping
        List<List<String>> phoneNumbers = customers.stream()
                .map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers);

        // List<Customer> convert List<String> -> Data Transformation
        // mapping: customer -> phone numbers
        // customer -> customer.getPhoneNumbers() -> one-to-many mapping
        List<String> phoneNumbers2 = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println(phoneNumbers2);
    }
}
