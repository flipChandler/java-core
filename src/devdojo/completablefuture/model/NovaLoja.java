package devdojo.completablefuture.model;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;

public class NovaLoja {

    public static final int TAMANHO = Desconto.Codigo.values().length;
    private String nome;

    public NovaLoja(String nome) {
        this.nome = nome;
    }

    public NovaLoja() {
    }

    public String getPreco() {
        double preco = calcularPreco();
        Desconto.Codigo codigo = Desconto.Codigo
                .values()[ThreadLocalRandom
                .current()
                .nextInt(TAMANHO)];

        return String.format("%s:%.2f:%s", this.nome, preco, codigo);
    }


    private double calcularPreco() {
        delay();
        // System.out.println(1 / 0); // para causar exception
        return ThreadLocalRandom.current().nextDouble() * 100;
    }

    private static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNome() {
        return nome;
    }

    public static List<NovaLoja> lojas() {
        return asList(new NovaLoja("americanas"),
                new NovaLoja("casas bahia"),
                new NovaLoja("bestbuy"),
                new NovaLoja("amazon"));
    }
}
