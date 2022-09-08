package devdojo.completablefuture.model;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {

    private String nome;

    public Loja(String nome) {
        this.nome = nome;
    }

    public Loja() {
    }

    public double getPreco() {
        return calcularPreco();
    }

    public Future<Double> getPrecoAsyncMelhor() {
        return CompletableFuture.supplyAsync(this::calcularPreco);
    }

    public Future<Double> getPrecoAsync() {
        CompletableFuture<Double> precoFuturo = new CompletableFuture<>();
        new Thread(() -> {
            try {
                precoFuturo.complete(calcularPreco());
            } catch (Exception e) {
                precoFuturo.completeExceptionally(e);   // finaliza com a exception
            }
        }).start();
        return precoFuturo;
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
}
