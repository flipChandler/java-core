package devsuperior.functionallambda.bipredicate;

import java.util.function.BiPredicate;

public class Application {

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> verificarSeMaior =
                (parametro, valorComparacao) -> parametro > valorComparacao;

        System.out.println(verificarSeMaior.test(13, 12));
        System.out.println(verificarSeMaior.test(15, 19));
    }
}
