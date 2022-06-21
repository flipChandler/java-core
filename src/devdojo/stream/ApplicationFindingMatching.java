package devdojo.stream;

import java.util.Comparator;
import java.util.List;

public class ApplicationFindingMatching {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Pessoa.bancoDePessoas();

        boolean alguemTemSalarioMaiorQueQuatroMil = pessoas.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 4000);
        System.out.println(alguemTemSalarioMaiorQueQuatroMil);   // true

        boolean todosSaoMaiorDeDezoitoAnos = pessoas.stream()
                .allMatch(pessoa -> pessoa.getIdade() > 18);
        System.out.println(todosSaoMaiorDeDezoitoAnos);    // false

        boolean nenhumMaiorDeDezoiotAnos = pessoas.stream()
                .noneMatch(pessoa -> pessoa.getIdade() < 18);
        System.out.println(nenhumMaiorDeDezoiotAnos);    // false

        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() < 25)
                .findAny()          // returns an optional of pessoa
                .ifPresent(pessoa -> System.out.println(pessoa.getNome()));

        pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 30)
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findFirst()        // returns an optional of pessoa
                .ifPresent(pessoa -> System.out.println(pessoa.getNome()));
    }
}

//  anyMatch  -> Se haver alguém na lista que retorna true;
//  allMatch    -> Se todos na lista retornam true;
//  noneMatch -> Se todos na lista retornam false;

