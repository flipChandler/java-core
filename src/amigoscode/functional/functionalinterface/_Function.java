package amigoscode.functional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    // Function :: apply()
    public static void main(String[] args) {
        System.out.println(increment(0));

        System.out.println(incrementOneByFunction.apply(0));

        System.out.println(multiplyBy10Function.apply(incrementOneByFunction.apply(1)));

        System.out.println(addByOneAndThenMultiplyBy10.apply(4));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply( 4, 100));
    }

    static int increment(int number) {
        return number + 1;
    }

    static Function<Integer, Integer> incrementOneByFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    // chaining a function in another
    static Function<Integer, Integer> addByOneAndThenMultiplyBy10 =
            incrementOneByFunction.andThen(multiplyBy10Function);

    static int incrementByOneAndMultply(int number, int numberToMultply) {
        return (number + 1) * numberToMultply;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrement, numberToMultply) -> (numberToIncrement + 1) * numberToMultply;
}
