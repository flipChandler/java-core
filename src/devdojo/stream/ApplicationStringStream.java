package devdojo.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationStringStream {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();

        Stream.of("Felipe", "Angelina", "Milla", "Brad", "The Rock")
                .map(String::toUpperCase)
                .forEach(nome -> System.out.print(nome + " "));

        System.out.println();

        var path = "/home/felipe/Documents/cursos/dev-superior/ws-java-8/java-8/src/devsuperior/in.txt";
        try (Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    .filter(word -> word.contains("uc"))
                    .forEach(System.out::println);  // Bruce Willis
        } catch (IOException e) {
            e.printStackTrace();
        }

        var todosNomes = pessoas.stream()
                .map(Pessoa::getNome)
                .collect(Collectors.joining());
        System.out.println(todosNomes);
        // Chester BenningtonAlicia KissAlanis MorisseteSchopenhauerKierkegaardSalomãoMalaquiasMalaquiasNabucodonosor

        todosNomes = pessoas.stream()
                .map(Pessoa::getNome)
                .collect(Collectors.joining(", "));
        System.out.println(todosNomes);
        // Chester Bennington, Alicia Kiss, Alanis Morissete, Schopenhauer, Kierkegaard, Salomão, Malaquias, Malaquias, Nabucodonosor
    }
}
