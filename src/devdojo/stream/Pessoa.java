package devdojo.stream;

import java.util.List;
import java.util.Objects;

import static devdojo.stream.EGenero.FEMININO;
import static devdojo.stream.EGenero.MASCULINO;
import static java.util.Arrays.asList;

public class Pessoa {

    private String nome;
    private int idade;
    private double salario;
    private EGenero genero;

    public Pessoa(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public Pessoa(String nome, int idade, double salario, EGenero genero) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.genero = genero;
    }

    public static List<Pessoa> bancoDePessoas() {
        return asList(
                new Pessoa("Chester Bennington", 22, 3500.0, MASCULINO),
                new Pessoa("Alicia Kiss", 35, 4500.0, FEMININO),
                new Pessoa("Alanis Morissete", 17, 8500.0, FEMININO),
                new Pessoa("Schopenhauer", 21, 5500.0, MASCULINO),
                new Pessoa("Kierkegaard", 79, 1500.0, MASCULINO),
                new Pessoa("Salomão", 38, 4000.0, MASCULINO),
                new Pessoa("Malaquias", 18, 6500.0, MASCULINO),
                new Pessoa("Malaquias", 18, 6500.0, MASCULINO),
                new Pessoa("Nabucodonosor", 33, 12500.0, MASCULINO)
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public EGenero getGenero() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
