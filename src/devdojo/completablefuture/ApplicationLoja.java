package devdojo.completablefuture;

import devdojo.completablefuture.model.Loja;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ApplicationLoja {

    public static void main(String[] args) {
        Loja americanas = new Loja();
        Loja casasBahia = new Loja();
        Loja bestBuy = new Loja();
        Loja wallmart = new Loja();
        Loja submarino = new Loja();

        // sincrona
        long start = System.currentTimeMillis();
        System.out.println(americanas.getPreco());
        System.out.println(casasBahia.getPreco());
        System.out.println(bestBuy.getPreco());
        System.out.println(wallmart.getPreco());
        System.out.println(submarino.getPreco());
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms"); // 10005 ms

        // assincrona
//        long start2 = System.currentTimeMillis();
//        Future<Double> precoAsyncAmericanas = americanas.getPrecoAsync();
//        Future<Double> precoAsyncCasasBahia = casasBahia.getPrecoAsync();
//        Future<Double> precoAsyncBestBuy = bestBuy.getPrecoAsync();
//        Future<Double> precoAsyncWalMart = wallmart.getPrecoAsync();
//        Future<Double> precoAsyncSubmarino = submarino.getPrecoAsync();
//        long end2 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        Future<Double> precoAsyncAmericanas = americanas.getPrecoAsyncMelhor();
        Future<Double> precoAsyncCasasBahia = casasBahia.getPrecoAsyncMelhor();
        Future<Double> precoAsyncBestBuy = bestBuy.getPrecoAsyncMelhor();
        Future<Double> precoAsyncWalMart = wallmart.getPrecoAsyncMelhor();
        Future<Double> precoAsyncSubmarino = submarino.getPrecoAsyncMelhor();
        long end2 = System.currentTimeMillis();

        System.out.println("Tempo de invocação: " + (end2 - start2) + " ms"); // Tempo de invocação: 8 ms
        enrolando();

        // para java 8, colocar get(3, TimeUnit.SECONDS) por precaucao
        // se uma exception surgir, no maximo 3 segundos pra esperar executar
        // boa pratica
        try {
            System.out.println("Americanas " + precoAsyncAmericanas.get());
            System.out.println("Casas Bahia " + precoAsyncCasasBahia.get());
            System.out.println("Best Buy " + precoAsyncBestBuy.get());
            System.out.println("WalMart " + precoAsyncWalMart.get());
            System.out.println("Submarino " + precoAsyncSubmarino.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        end2 = System.currentTimeMillis();
        // Tempo para pegar o resultado: 2018 ms
        // esses 2 segundos é do delay TimeUnit.SECONDS.sleep(2);
        System.out.println("Tempo para pegar o resultado: " + (end2 - start2) + " ms");
    }

    private static void enrolando() {
        long soma = 0;
        for (int i = 0; i < 1_000_000; i++) {
            soma += i;
        }
        System.out.println(soma);
    }
}
