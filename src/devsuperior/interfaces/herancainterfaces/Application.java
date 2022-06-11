package devsuperior.interfaces.herancainterfaces;

import devsuperior.interfaces.herancainterfaces.enums.Color;
import devsuperior.interfaces.herancainterfaces.model.AbstractShape;
import devsuperior.interfaces.herancainterfaces.model.Circle;
import devsuperior.interfaces.herancainterfaces.model.Rectangle;

public class Application {

    public static void main(String[] args) {
        AbstractShape shape1 = new Circle(Color.BLACK, 2.0);
        AbstractShape shape2 = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle color: " + shape1.getColor());
        System.out.println("Circle area: " + String.format("%.3f", shape1.area()));
        System.out.println("rectangle color: " + shape2.getColor());
        System.out.println("rectangle area: " + String.format("%.3f", shape2.area()));
    }
}
