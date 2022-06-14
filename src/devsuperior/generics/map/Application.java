package devsuperior.generics.map;

import java.util.Map;
import java.util.TreeMap;

public class Application {

    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "88711112222");

        cookies.remove("email");
        cookies.put("phone", "782711112222");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());


        System.out.println("ALL COOKIES:");
        for (var key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
