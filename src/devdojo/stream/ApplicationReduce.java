package devdojo.stream;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ApplicationReduce {

    public static void main(String[] args) {
        List<Integer> lista = getLista();
        int soma = lista.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(soma);       // 21

        Optional<Integer> optionalSoma = lista.stream()
                .reduce(Integer::sum);
        System.out.println(optionalSoma.get());     // 21

        int produto = getLista().stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(produto);        // 720

        Optional<Integer> optionalMaxUgly = getLista().stream()
                .reduce((x, y) -> x > y ? x : y);
        System.out.println(optionalMaxUgly.get());      // 6

        Optional<Integer> optionalMax = getLista().stream()
                .reduce(Integer::max);
        System.out.println(optionalMax.get());      // 6

        Optional<Integer> optionalMin = getLista().stream()
                .reduce(Integer::min);
        System.out.println(optionalMin.get());      // 1

        Integer minValue = getLista().stream()
                .min(Integer::compare)
                .get();
        System.out.println(minValue);               // 1

        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Optional<Double> optionalSomaSalario = pessoas.stream()
                .filter(pessoa -> pessoa.getSalario() > 4000)
                .map(Pessoa::getSalario)
                .reduce(Double::sum);   // força o Wrap, pois, salario é double
        System.out.println(optionalSomaSalario.get());

        Double somaSalario = pessoas.stream()
                .filter(pessoa -> pessoa.getSalario() > 4000)
                .mapToDouble(Pessoa::getSalario)    // melhor usar esse map que é DoubleStream
                .sum();
        System.out.println(somaSalario);

        DoubleStream doubleStream = pessoas.stream()
                .filter(pessoa -> pessoa.getSalario() > 4000)
                .mapToDouble(Pessoa::getSalario);

        Stream<Double> streamDeDouble = doubleStream.boxed();   // retorna o doubleStream para Stream de Double

        var maxSalary = pessoas.stream()
                .map(Pessoa::getSalario)
                .reduce(0.0, Double::max);

        System.out.println(maxSalary);

        var maxSalary2 = pessoas.stream()
                .map(Pessoa::getSalario)
                .max(Double::compare)
                .get();

        System.out.println(maxSalary2);

        var minSalary = pessoas.stream()
                .map(Pessoa::getSalario)
                .min(Double::compare)
                .get();

        System.out.println(minSalary);

        var firstName = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .map(Pessoa::getNome)
                .findFirst()
                .get();

        System.out.println(firstName);

        var lastName = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome).reversed())
                .map(Pessoa::getNome)
                .findFirst()
                .get();

        System.out.println(lastName);

        var youngerPerson = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .findFirst()
                .get();

        System.out.println(youngerPerson);

        var olderPerson = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findFirst()
                .get();

        System.out.println(olderPerson);
    }

    private static List<Integer> getLista() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
