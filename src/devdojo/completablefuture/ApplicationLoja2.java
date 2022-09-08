package devdojo.completablefuture;

import devdojo.completablefuture.model.Loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ApplicationLoja2 {

    public static void main(String[] args) {
        List<Loja> lojas = asList(
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"));

        acharPrecosStream(lojas);                   // Tempo total: 4015 ms
        acharPrecosParallelStream(lojas);           // Tempo total: 1028 ms
        acharPrecosCompletableFuture(lojas);        // Tempo total: 1007 ms
        acharPrecosCompletableFutureAsync(lojas);   // Tempo de invocação: 2 ms e Tempo Total: 1002 ms
    }

    private static void acharPrecosStream(List<Loja> lojas) {
        System.out.println("Stream sequencial");
        long start = System.currentTimeMillis();

        List<String> lista = lojas.stream()
                .map(loja -> String.format("%s o preco é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: " + (end -start) + " ms"); // Tempo total: 4025 ms
        System.out.println(lista);
    }

    private static void acharPrecosParallelStream(List<Loja> lojas) {
        System.out.println("Stream Paralelos");
        long start = System.currentTimeMillis();

        List<String> lista = lojas.parallelStream()
                .map(loja -> String.format("%s o preco é: %.2f", loja.getNome(), loja.getPreco()))
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: " + (end -start) + " ms"); // Tempo total: 1012 ms
        System.out.println(lista);
    }

    private static void acharPrecosCompletableFuture(List<Loja> lojas) {
        System.out.println("CompletableFuture Sequencial");
        long start = System.currentTimeMillis();

        List<String> lista = lojas.parallelStream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: %.2f", loja.getNome(), loja.getPreco())))
                .map(CompletableFuture::join)   // join == get, só não lanca exception
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo total: " + (end -start) + " ms"); // Tempo total: 1006 ms
        System.out.println(lista);
    }

    private static void acharPrecosCompletableFutureAsync(List<Loja> lojas) {
        System.out.println("CompletableFuture Async");
        long start = System.currentTimeMillis();

        List<CompletableFuture<String>> lista = lojas.parallelStream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: %.2f", loja.getNome(), loja.getPreco())))
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Tempo de invocação: " + (end - start) + " ms");     // 2 ms

        List<String> listaFinal = lista.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        end = System.currentTimeMillis();

        System.out.println("Tempo total: " + (end -start) + " ms"); // Tempo total: 1002 ms
        System.out.println(listaFinal);
    }
}
