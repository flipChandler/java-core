package devdojo.stream;

import java.util.*;
import java.util.stream.Collectors;

import static devdojo.stream.EGenero.FEMININO;
import static devdojo.stream.EGenero.MASCULINO;
import static devdojo.stream.EMaioridade.ADULTO;
import static devdojo.stream.EMaioridade.MENOR;

public class ApplicationGroupingBy {

    public static void main(String[] args) {
        // java 7
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();
        Map<EGenero, List<Pessoa>> generoListaMap = new HashMap<>();
        List<Pessoa> listaMasculinos = new ArrayList<>();
        List<Pessoa> listaFemininos = new ArrayList<>();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getGenero() == FEMININO) {
                listaFemininos.add(pessoa);
            } else {
                listaMasculinos.add(pessoa);
            }
        }
        generoListaMap.put(FEMININO, listaFemininos);
        generoListaMap.put(MASCULINO, listaMasculinos);
        System.out.println(generoListaMap);

        // java 8
        Map<EGenero, List<Pessoa>> pessoasPorGenero = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero));
        System.out.println(pessoasPorGenero);

        Map<EMaioridade, List<Pessoa>> pessoasPorMaioridade = pessoas.stream()
                .collect(Collectors.groupingBy(pessoa -> {
                    if (pessoa.getIdade() < 18) {
                        return MENOR;
                    }
                    return ADULTO;
                }));
        System.out.println(pessoasPorMaioridade);

        // pessoas por genero e maioridade
        Map<EGenero, Map<EMaioridade, List<Pessoa>>> porGeneroEMaioridade = pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getGenero,
                        Collectors.groupingBy(pessoa -> {
                            if (pessoa.getIdade() < 18) {
                                return MENOR;
                            }
                            return ADULTO;
                        })));

        System.out.println(porGeneroEMaioridade);

        // por genero e quantidade
        Map<EGenero, Long> porGeneroEQuantidade = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.counting()));
        System.out.println(porGeneroEQuantidade);

        // por genero e maior salario c/ optional
        Map<EGenero, Optional<Pessoa>> porGeneroEMaiorSalarioOp = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
        System.out.println(porGeneroEMaiorSalarioOp);

        // por genero e maior salario s/ optional
        Map<EGenero, Pessoa> porGeneroEMaiorSalario = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Pessoa::getSalario)),
                                Optional::get
                        )));
        System.out.println(porGeneroEMaiorSalario);

        // agrupando por genero e estatisticas
        Map<EGenero, DoubleSummaryStatistics> porGeneroSalarioSummarizing = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.summarizingDouble(Pessoa::getSalario)));
        System.out.println(porGeneroSalarioSummarizing);

        Map<EGenero, Set<EMaioridade>> porGeneroEMaioridade2 = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.mapping(pessoa -> {
                            if (pessoa.getIdade() < 18) {
                                return MENOR;
                            }
                            return ADULTO;
                        }, Collectors.toSet())));

        System.out.println(porGeneroEMaioridade2);

        Map<EGenero, Set<EMaioridade>> porGeneroEMaioridade3 = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getGenero,
                        Collectors.mapping(pessoa -> {
                            if (pessoa.getIdade() < 18) {
                                return MENOR;
                            }
                            return ADULTO;
                        }, Collectors.toCollection(LinkedHashSet::new))));

        System.out.println(porGeneroEMaioridade3);
    }
}
