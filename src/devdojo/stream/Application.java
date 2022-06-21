package devdojo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Application {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();

        List<String> nomes = pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() < 25)
                .limit(3)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .skip(1)
                .map(pessoa -> pessoa.getNome())
                .collect(Collectors.toList());

        System.out.println(nomes);

        var quantidadePessoas = pessoas.stream()
                .distinct()
                .filter(pessoa -> pessoa.getIdade() < 25)
                .count();

        System.out.println("Quantidade de pessoas abaixo de 25 anos: " + quantidadePessoas);

        pessoas.forEach(System.out::println);

        List<List<String>> frases = new ArrayList<>();
        frases.add(asList("Felipe", "estudante de Java"));
        frases.add(asList("Maverick", "piloto de avião"));
        frases.add(asList("Eminem", "rapper"));

        List<String> lista = frases.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(lista);

        List<String> palavras = asList("Ola", "Goku");
        String[] palavrasSplit = palavras.get(0).split("");
        System.out.println(Arrays.toString(palavrasSplit)); // [O, l, a]

        // não queremos lista de vetor de string, mas uma lista de string
        List<String[]> listaVetor = palavras.stream()
                .map(palavra -> palavra.split(""))
                .collect(Collectors.toList());

        List<String> listaString = palavras.stream()
                .map(palavra -> palavra.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(listaString); // [O, l, a, G, o, k, u]
    }

}
