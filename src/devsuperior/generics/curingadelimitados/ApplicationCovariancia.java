package devsuperior.generics.curingadelimitados;

import java.util.ArrayList;
import java.util.List;

public class ApplicationCovariancia {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(45);

        List<? extends Number> numberList = intList;

        Number number = numberList.get(0);  // covariancia = get OK, put error

        // numberList.add(15); compilation error
    }
}
