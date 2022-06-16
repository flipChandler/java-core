package devsuperior.functionallambda.unaryoperator;

import java.util.function.UnaryOperator;

public class Application {

    public static void main(String[] args) {
        UnaryOperator<Integer> calcularValorVezesTres = valor -> valor * 3;
        System.out.println("O resultado é :: " + calcularValorVezesTres.apply(10));

        UnaryOperator<Integer> retornarODobro = valor -> valor * 2;
        System.out.println("O dobro é :: " + retornarODobro.apply(10));
    }
}
