package devdojo.completablefuture;

import devdojo.completablefuture.model.Loja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class ApplicationLoja3 {

    public static void main(String[] args) {
        List<Loja> lojas = asList(
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"),
                new Loja("americanas"),
                new Loja("casas bahia"),
                new Loja("best buy"),
                new Loja("walmart"));

        acharPrecosStream(lojas);                   // Tempo total: 4015 ms
        acharPrecosParallelStream(lojas);           // Tempo total: 1028 ms
        acharPrecosCompletableFuture(lojas);        // Tempo total: 1007 ms
        acharPrecosCompletableFutureAsync(lojas);   // Tempo de invocação: 2 ms e Tempo Total: 1002 ms

        // find out the ideal number of threads
        // NumberOfThreads = Ncpu * Ucpu * (1 + W / C)
        // Ncpu = number of available cores
        // Ucpu = quantity of cpu using (0-1) means 100% using of CPU | (0 - 0.5) :: 50%
        // W / C = wait time and compute time
        // NumberOfThreads = 8 * 1 * (1 + 99) = 800 threads needed

        final Executor executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), runnable -> {
           Thread thread = new Thread(runnable);
           thread.setDaemon(true);  // if one thread not daemon is over, all daemon thread waiting is finished too
           return thread;
        });
        System.out.println(Runtime.getRuntime().availableProcessors()); // number of cores

        acharPrecosCompletableFuture(lojas, executor);
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

    private static void acharPrecosCompletableFuture(List<Loja> lojas, Executor executor) {
        System.out.println("CompletableFuture Sequencial Executor");
        long start = System.currentTimeMillis();

        List<String> lista = lojas.parallelStream()
                .map(loja -> CompletableFuture.supplyAsync(
                        () -> String.format("%s o preco é: %.2f", loja.getNome(), loja.getPreco()),
                        executor))
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
 /*
 Stream sequencial
Tempo total: 84061 ms
[americanas o preco é: 75.25, casas bahia o preco é: 89.95, best buy o preco é: 49.22, walmart o preco é: 48.10, americanas o preco é: 38.11, casas bahia o preco é: 97.95, best buy o preco é: 64.93, walmart o preco é: 28.30, americanas o preco é: 12.46, casas bahia o preco é: 67.00, best buy o preco é: 49.44, walmart o preco é: 29.10, americanas o preco é: 62.90, casas bahia o preco é: 38.86, best buy o preco é: 81.31, walmart o preco é: 75.39, americanas o preco é: 39.22, casas bahia o preco é: 98.13, best buy o preco é: 41.20, walmart o preco é: 72.26, americanas o preco é: 85.68, casas bahia o preco é: 31.92, best buy o preco é: 7.64, walmart o preco é: 79.13, americanas o preco é: 83.82, casas bahia o preco é: 40.88, best buy o preco é: 19.71, walmart o preco é: 16.64, americanas o preco é: 78.13, casas bahia o preco é: 90.13, best buy o preco é: 9.29, walmart o preco é: 31.82, americanas o preco é: 29.33, casas bahia o preco é: 71.86, best buy o preco é: 73.70, walmart o preco é: 92.36, americanas o preco é: 91.09, casas bahia o preco é: 81.09, best buy o preco é: 85.73, walmart o preco é: 28.24, americanas o preco é: 86.34, casas bahia o preco é: 75.11, best buy o preco é: 65.97, walmart o preco é: 55.03, americanas o preco é: 59.65, casas bahia o preco é: 90.65, best buy o preco é: 80.32, walmart o preco é: 50.88, americanas o preco é: 76.18, casas bahia o preco é: 4.47, best buy o preco é: 94.10, walmart o preco é: 54.80, americanas o preco é: 89.14, casas bahia o preco é: 12.63, best buy o preco é: 84.32, walmart o preco é: 83.87, americanas o preco é: 70.68, casas bahia o preco é: 82.19, best buy o preco é: 78.28, walmart o preco é: 36.85, americanas o preco é: 37.69, casas bahia o preco é: 41.29, best buy o preco é: 90.40, walmart o preco é: 56.61, americanas o preco é: 9.22, casas bahia o preco é: 58.00, best buy o preco é: 89.53, walmart o preco é: 88.43, americanas o preco é: 81.28, casas bahia o preco é: 50.54, best buy o preco é: 99.10, walmart o preco é: 70.22, americanas o preco é: 20.27, casas bahia o preco é: 19.09, best buy o preco é: 67.96, walmart o preco é: 39.18, americanas o preco é: 41.07, casas bahia o preco é: 93.88, best buy o preco é: 9.11, walmart o preco é: 15.98, americanas o preco é: 4.87, casas bahia o preco é: 86.54, best buy o preco é: 36.02, walmart o preco é: 15.74]
Stream Paralelos
Tempo total: 13035 ms
[americanas o preco é: 38.16, casas bahia o preco é: 4.56, best buy o preco é: 3.08, walmart o preco é: 58.94, americanas o preco é: 41.46, casas bahia o preco é: 2.41, best buy o preco é: 75.20, walmart o preco é: 54.02, americanas o preco é: 76.22, casas bahia o preco é: 36.32, best buy o preco é: 3.01, walmart o preco é: 95.21, americanas o preco é: 7.29, casas bahia o preco é: 79.97, best buy o preco é: 98.78, walmart o preco é: 66.87, americanas o preco é: 78.96, casas bahia o preco é: 93.90, best buy o preco é: 15.86, walmart o preco é: 71.07, americanas o preco é: 43.50, casas bahia o preco é: 27.63, best buy o preco é: 13.78, walmart o preco é: 57.21, americanas o preco é: 14.80, casas bahia o preco é: 1.05, best buy o preco é: 33.21, walmart o preco é: 3.31, americanas o preco é: 63.95, casas bahia o preco é: 43.91, best buy o preco é: 25.49, walmart o preco é: 41.65, americanas o preco é: 18.53, casas bahia o preco é: 10.75, best buy o preco é: 12.65, walmart o preco é: 34.37, americanas o preco é: 99.16, casas bahia o preco é: 75.97, best buy o preco é: 71.53, walmart o preco é: 39.43, americanas o preco é: 67.37, casas bahia o preco é: 40.29, best buy o preco é: 93.94, walmart o preco é: 56.52, americanas o preco é: 30.59, casas bahia o preco é: 32.89, best buy o preco é: 54.41, walmart o preco é: 94.43, americanas o preco é: 17.71, casas bahia o preco é: 66.27, best buy o preco é: 24.01, walmart o preco é: 70.11, americanas o preco é: 39.19, casas bahia o preco é: 29.58, best buy o preco é: 26.12, walmart o preco é: 90.50, americanas o preco é: 65.09, casas bahia o preco é: 52.51, best buy o preco é: 1.06, walmart o preco é: 75.01, americanas o preco é: 72.89, casas bahia o preco é: 88.57, best buy o preco é: 44.30, walmart o preco é: 90.82, americanas o preco é: 45.34, casas bahia o preco é: 41.28, best buy o preco é: 97.48, walmart o preco é: 94.92, americanas o preco é: 61.85, casas bahia o preco é: 51.07, best buy o preco é: 98.46, walmart o preco é: 28.77, americanas o preco é: 83.91, casas bahia o preco é: 38.92, best buy o preco é: 62.93, walmart o preco é: 14.94, americanas o preco é: 29.23, casas bahia o preco é: 38.39, best buy o preco é: 18.17, walmart o preco é: 43.56, americanas o preco é: 88.18, casas bahia o preco é: 82.49, best buy o preco é: 19.19, walmart o preco é: 18.33]
CompletableFuture Sequencial
Tempo total: 34038 ms
[americanas o preco é: 90.78, casas bahia o preco é: 29.02, best buy o preco é: 85.60, walmart o preco é: 7.86, americanas o preco é: 22.91, casas bahia o preco é: 88.82, best buy o preco é: 16.86, walmart o preco é: 88.12, americanas o preco é: 64.43, casas bahia o preco é: 86.05, best buy o preco é: 50.81, walmart o preco é: 8.96, americanas o preco é: 60.73, casas bahia o preco é: 80.16, best buy o preco é: 87.64, walmart o preco é: 78.99, americanas o preco é: 47.01, casas bahia o preco é: 2.38, best buy o preco é: 72.55, walmart o preco é: 94.18, americanas o preco é: 91.30, casas bahia o preco é: 52.78, best buy o preco é: 38.76, walmart o preco é: 3.25, americanas o preco é: 29.60, casas bahia o preco é: 82.77, best buy o preco é: 21.09, walmart o preco é: 20.06, americanas o preco é: 40.58, casas bahia o preco é: 83.90, best buy o preco é: 39.11, walmart o preco é: 39.34, americanas o preco é: 69.95, casas bahia o preco é: 44.40, best buy o preco é: 51.75, walmart o preco é: 34.16, americanas o preco é: 91.06, casas bahia o preco é: 24.99, best buy o preco é: 96.27, walmart o preco é: 14.74, americanas o preco é: 75.80, casas bahia o preco é: 82.24, best buy o preco é: 94.76, walmart o preco é: 85.14, americanas o preco é: 93.91, casas bahia o preco é: 93.61, best buy o preco é: 64.02, walmart o preco é: 97.17, americanas o preco é: 61.85, casas bahia o preco é: 36.41, best buy o preco é: 27.79, walmart o preco é: 73.24, americanas o preco é: 35.31, casas bahia o preco é: 18.27, best buy o preco é: 48.28, walmart o preco é: 30.81, americanas o preco é: 82.98, casas bahia o preco é: 85.92, best buy o preco é: 98.67, walmart o preco é: 65.80, americanas o preco é: 74.21, casas bahia o preco é: 9.32, best buy o preco é: 30.58, walmart o preco é: 55.50, americanas o preco é: 69.43, casas bahia o preco é: 35.95, best buy o preco é: 36.21, walmart o preco é: 72.63, americanas o preco é: 71.93, casas bahia o preco é: 23.73, best buy o preco é: 40.21, walmart o preco é: 67.13, americanas o preco é: 39.04, casas bahia o preco é: 93.21, best buy o preco é: 60.61, walmart o preco é: 63.20, americanas o preco é: 73.37, casas bahia o preco é: 34.29, best buy o preco é: 60.16, walmart o preco é: 31.47, americanas o preco é: 56.35, casas bahia o preco é: 73.21, best buy o preco é: 79.60, walmart o preco é: 45.73]
CompletableFuture Async
Tempo de invocação: 11009 ms
Tempo total: 12012 ms
[americanas o preco é: 8.61, casas bahia o preco é: 27.09, best buy o preco é: 76.43, walmart o preco é: 31.63, americanas o preco é: 83.27, casas bahia o preco é: 20.84, best buy o preco é: 39.65, walmart o preco é: 70.62, americanas o preco é: 36.26, casas bahia o preco é: 12.65, best buy o preco é: 2.45, walmart o preco é: 6.56, americanas o preco é: 42.90, casas bahia o preco é: 85.46, best buy o preco é: 3.58, walmart o preco é: 69.56, americanas o preco é: 42.47, casas bahia o preco é: 33.55, best buy o preco é: 45.08, walmart o preco é: 67.42, americanas o preco é: 28.28, casas bahia o preco é: 40.03, best buy o preco é: 22.04, walmart o preco é: 23.73, americanas o preco é: 9.73, casas bahia o preco é: 47.04, best buy o preco é: 32.24, walmart o preco é: 19.36, americanas o preco é: 37.66, casas bahia o preco é: 41.77, best buy o preco é: 23.57, walmart o preco é: 50.86, americanas o preco é: 43.28, casas bahia o preco é: 89.48, best buy o preco é: 38.41, walmart o preco é: 18.40, americanas o preco é: 33.95, casas bahia o preco é: 60.60, best buy o preco é: 40.52, walmart o preco é: 40.10, americanas o preco é: 65.31, casas bahia o preco é: 48.03, best buy o preco é: 45.41, walmart o preco é: 29.58, americanas o preco é: 30.79, casas bahia o preco é: 55.96, best buy o preco é: 47.52, walmart o preco é: 61.62, americanas o preco é: 72.24, casas bahia o preco é: 7.64, best buy o preco é: 78.54, walmart o preco é: 66.10, americanas o preco é: 39.21, casas bahia o preco é: 6.59, best buy o preco é: 74.78, walmart o preco é: 12.03, americanas o preco é: 18.33, casas bahia o preco é: 24.09, best buy o preco é: 72.16, walmart o preco é: 91.62, americanas o preco é: 19.31, casas bahia o preco é: 52.46, best buy o preco é: 8.73, walmart o preco é: 28.14, americanas o preco é: 19.64, casas bahia o preco é: 15.32, best buy o preco é: 15.01, walmart o preco é: 58.44, americanas o preco é: 46.06, casas bahia o preco é: 41.26, best buy o preco é: 74.71, walmart o preco é: 1.06, americanas o preco é: 70.28, casas bahia o preco é: 60.15, best buy o preco é: 11.92, walmart o preco é: 79.08, americanas o preco é: 12.55, casas bahia o preco é: 64.64, best buy o preco é: 9.44, walmart o preco é: 88.47, americanas o preco é: 65.24, casas bahia o preco é: 2.35, best buy o preco é: 16.81, walmart o preco é: 9.51]
8
CompletableFuture Sequencial Executor
Tempo total: 3023 ms
[americanas o preco é: 88.06, casas bahia o preco é: 85.81, best buy o preco é: 77.52, walmart o preco é: 65.14, americanas o preco é: 21.92, casas bahia o preco é: 18.82, best buy o preco é: 57.01, walmart o preco é: 44.97, americanas o preco é: 8.15, casas bahia o preco é: 52.62, best buy o preco é: 76.42, walmart o preco é: 1.13, americanas o preco é: 31.04, casas bahia o preco é: 0.23, best buy o preco é: 97.11, walmart o preco é: 53.68, americanas o preco é: 7.81, casas bahia o preco é: 84.06, best buy o preco é: 34.73, walmart o preco é: 15.60, americanas o preco é: 8.44, casas bahia o preco é: 15.59, best buy o preco é: 80.46, walmart o preco é: 92.28, americanas o preco é: 72.48, casas bahia o preco é: 76.75, best buy o preco é: 71.45, walmart o preco é: 21.98, americanas o preco é: 33.93, casas bahia o preco é: 58.45, best buy o preco é: 63.08, walmart o preco é: 96.98, americanas o preco é: 58.85, casas bahia o preco é: 52.54, best buy o preco é: 69.09, walmart o preco é: 26.86, americanas o preco é: 62.82, casas bahia o preco é: 22.52, best buy o preco é: 77.29, walmart o preco é: 47.23, americanas o preco é: 55.55, casas bahia o preco é: 92.45, best buy o preco é: 39.39, walmart o preco é: 41.57, americanas o preco é: 38.58, casas bahia o preco é: 87.24, best buy o preco é: 87.53, walmart o preco é: 57.98, americanas o preco é: 28.72, casas bahia o preco é: 31.04, best buy o preco é: 87.65, walmart o preco é: 66.22, americanas o preco é: 48.66, casas bahia o preco é: 1.96, best buy o preco é: 6.93, walmart o preco é: 88.45, americanas o preco é: 93.34, casas bahia o preco é: 73.31, best buy o preco é: 20.94, walmart o preco é: 22.72, americanas o preco é: 29.31, casas bahia o preco é: 56.24, best buy o preco é: 80.00, walmart o preco é: 46.10, americanas o preco é: 13.86, casas bahia o preco é: 86.91, best buy o preco é: 73.39, walmart o preco é: 67.61, americanas o preco é: 74.44, casas bahia o preco é: 1.49, best buy o preco é: 26.13, walmart o preco é: 70.44, americanas o preco é: 41.18, casas bahia o preco é: 64.17, best buy o preco é: 93.12, walmart o preco é: 65.24, americanas o preco é: 82.98, casas bahia o preco é: 45.95, best buy o preco é: 24.55, walmart o preco é: 51.83, americanas o preco é: 47.04, casas bahia o preco é: 37.48, best buy o preco é: 6.47, walmart o preco é: 77.82]
com Executor fo muito rapido

obs.: working waiting i/o, getting data from a hd, another PC, CompletableFuture with Executor is good
  */