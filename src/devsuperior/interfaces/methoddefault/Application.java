package devsuperior.interfaces.methoddefault;

import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        var scanner = new Scanner(System.in);

        System.out.print("Amount: ");
        var amount = scanner.nextDouble();
        System.out.print("Months: ");
        var months = scanner.nextInt();

        var interestService = new BrazilInterestService(2.0);
        var payment = interestService.payment(amount, months);

        System.out.println("Payment after " + months + " months: ");
        System.out.println(String.format("%.2f", payment));
    }
}
