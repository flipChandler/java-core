package devsuperior.hashcodeequals;

public class Application {

    public static void main(String[] args) {
        var client1 = new Client("Maria", "maria@gmail.com");
        var client2 = new Client("Maria", "maria@gmail.com");

        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());
        System.out.println(client1.equals(client2)); // true

        System.out.println(client1 == client2);     // false | different positions of memory

        String string1 = "Teste";
        String string2 = "Teste";

        System.out.println(string1 == string2);  // true | same reference of memory

        String string3 = new String("Teste");
        String string4 = new String("Teste");

        System.out.println(string3 == string4);  // false | different positions of memory

    }
}
