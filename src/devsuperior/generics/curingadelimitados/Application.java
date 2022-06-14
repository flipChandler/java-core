package devsuperior.generics.curingadelimitados;

import devsuperior.generics.curingadelimitados.model.Circle;
import devsuperior.generics.curingadelimitados.model.Rectangle;
import devsuperior.generics.curingadelimitados.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        var myShapes = new ArrayList<Shape>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        System.out.println("Total area: " + totalArea(myShapes));
    }

    // can be a list of shape or list of any subtype of shape
    private static double totalArea(List<? extends Shape> list) {
        var sum = 0.0;
        for (var shape : list) {
            sum += shape.area();
        }

        return sum;
    }
}
