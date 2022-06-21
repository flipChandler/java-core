package devdojo.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ApplicationSumarizing {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        var quantidadePessoas = pessoas.stream()
                .count();
        System.out.println(quantidadePessoas); // 9

        quantidadePessoas = pessoas.stream()
                        .collect(Collectors.counting());
        System.out.println(quantidadePessoas); // 9

        Optional<Double> maxSalario = pessoas.stream()
                .max(Comparator.comparing(Pessoa::getSalario))
                .map(Pessoa::getSalario);
        System.out.println(maxSalario.get());    // 12500.0

        maxSalario = pessoas.stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(Pessoa::getSalario)))
                .map(Pessoa::getSalario);
        System.out.println(maxSalario.get());    // 12500.0

        Optional<Double> minSalario = pessoas.stream()
                .collect(Collectors.minBy(
                        Comparator.comparing(Pessoa::getSalario)))
                .map(Pessoa::getSalario);
        System.out.println(minSalario.get());    // 1500.0

        OptionalDouble minSalarioOptionalDouble  = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .min();
        System.out.println(minSalarioOptionalDouble.getAsDouble()); // 1500.0

        Double somaSalarioOptionalDouble  = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .sum();
        System.out.println(somaSalarioOptionalDouble); // 53000.0

        somaSalarioOptionalDouble  = pessoas.stream()
                .collect(Collectors.summingDouble(Pessoa::getSalario));
        System.out.println(somaSalarioOptionalDouble); // 53000.0

        OptionalDouble averageSalarioOptionalDouble = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .average();
        System.out.println(averageSalarioOptionalDouble.getAsDouble()); // 5888.888888888889

        Double averageSalarioDouble = pessoas.stream()
                .collect(Collectors.averagingDouble(Pessoa::getSalario));
        System.out.println(averageSalarioDouble);                       // 5888.888888888889

        DoubleSummaryStatistics doubleSummaryStatistics = pessoas.stream()
                .collect(Collectors.summarizingDouble(Pessoa::getSalario));
        System.out.println(doubleSummaryStatistics);  // {count=9, sum=53000.000000, min=1500.000000, average=5888.888889, max=12500.000000}

        System.out.println(doubleSummaryStatistics.getSum()); // 53000.0
    }
}
