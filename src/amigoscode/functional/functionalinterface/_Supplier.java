package amigoscode.functional.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    // Supplier :: get -> takes no arguments () ->  and returns something
    public static void main(String[] args) {
        System.out.println(getDbConnectionUrl());
        System.out.println(getDbConnectionUrlBySupplier.get());
        System.out.println(getListDbConnectionUrlBySupplier.get());
    }

    static String getDbConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDbConnectionUrlBySupplier = () ->
            "jdbc://localhost:5432/users";

    static Supplier<List<String>> getListDbConnectionUrlBySupplier = () ->
            List.of(
                    "jdbc://localhost:5432/users",
                    "jdbc://localhost:3306/users",
                    "jdbc://localhost:1521/users");
}
