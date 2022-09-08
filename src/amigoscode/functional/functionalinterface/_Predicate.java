package amigoscode.functional.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    // Predicate :: test -> returns boolean
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("07000000000"));  // true
        System.out.println(isPhoneNumberValid("0700000000"));   // false
        System.out.println(isPhoneNumberValid("09973730000"));  // false

        System.out.println(isPhoneNumberValidByPredicate.test("07000000000"));  // true
        System.out.println(isPhoneNumberValidByPredicate.test("0700000000"));   // false
        System.out.println(isPhoneNumberValidByPredicate.test("09973730000"));  // false

        // chaining predicates
        System.out.println(isPhoneNumberValidByPredicate.and(containsNumber3).test("09973730000")); // false

        System.out.println(isPhoneNumberValidByPredicate.and(containsNumber3).test("07973730000")); // true

        System.out.println(isPhoneNumberValidByPredicate.or(containsNumber3).test("09973730000")); // true
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidByPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
