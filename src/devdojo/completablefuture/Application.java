package devdojo.completablefuture;

import java.util.concurrent.*;

public class Application {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        // java 5
        Future<Double> future = executorService.submit(() -> {
                TimeUnit.SECONDS.sleep(2);
                return 2000D;
        });

        enrolando();        // o que o seu sistema deveria estar fazendo

        try {
            while(!future.isDone()) {
                Double resultado = future.get();
                System.out.println(resultado);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    private static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }
}
