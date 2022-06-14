package devsuperior.generics.curingadelimitados;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContravariancia {

    public static void main(String[] args) {
        List<Object> myObjects = new ArrayList<>();
        myObjects.add("Maria");
        myObjects.add("John");
        myObjects.add("Brad");

        List<? super Number> myNumbers = myObjects;  // list of Number or list of any super type of number

        myNumbers.add(10);                           // add OK, get error
        myNumbers.add(3.14);

        // Number number = myNumbers.get(0); compilation error
    }
}
