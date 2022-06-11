package devsuperior.interfaces.exe;

import devsuperior.interfaces.exe.interfaces.model.Contract;
import devsuperior.interfaces.exe.interfaces.service.ContractService;
import devsuperior.interfaces.exe.interfaces.service.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        var scanner = new Scanner(System.in);
        var formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("======enter contract data=======");
        System.out.print("Number: ");
        var number = scanner.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        var date = formatter.parse(scanner.next());
        System.out.print("Contract value: ");
        var totalValue = scanner.nextDouble();

        var contract = new Contract(number, date, totalValue);

        System.out.println("enter number of installments: ");
        int numberOfInstallment = scanner.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.process(contract, numberOfInstallment);

        System.out.println("Installments: ");
        contract.getInstallments().forEach(System.out::println);

        scanner.close();
    }
}
