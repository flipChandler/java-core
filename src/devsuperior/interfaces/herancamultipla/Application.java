package devsuperior.interfaces.herancamultipla;

public class Application {

    public static void main(String[] args) {

        var printer = new ConcretePrinter("1080");
        printer.processDoc("My letter");
        printer.print(("My letter" + "\n"));

        var scanner = new ConcreteScanner("2003");
        scanner.processDoc("My email");
        System.out.println(scanner.scan() + "\n");

        var comboDevice = new ComboDevice("1500");
        comboDevice.print("My letter");
        System.out.println(comboDevice.scan());
        comboDevice.processDoc("My letter");
    }
}
