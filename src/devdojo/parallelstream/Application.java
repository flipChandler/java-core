package devdojo.parallelstream;

import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        long numero = 10_000_000_00;
        somaFor(numero);
        somaStreamIterate(numero);
        somaParallelStreamIterate(numero);
        System.out.println(Runtime.getRuntime().availableProcessors()); // 8 processadores
    }

    // prestar atenção!!!!!
    // as vezes um for é mais rápido do que um Stream.iterate
    // benchmark
    // boxing e unboxing dos objetos em Java | afeta a performance do sistema
    // algumas operações são piores paralelas do que sequenciais (limit e findFirst) | nao precisa que os elementos estejam ordenados
    // findAny e unordered(), são mais performáticos
    // considerar o custo total da computação N, P
    // quantidade de dados pequenos, não compensa parallel stream
    // tipos de coleções - ArrayList = excellent
    // tamanho do stream
    // processamento do merge
    private static void somaFor(long numero) {
        System.out.println("For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1L; i <= numero; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // 491 ms
    }

    private static void somaStreamIterate(long numero) {
        System.out.println("Stream Sequencial");
        long result = 0;
        long init = System.currentTimeMillis();

        result = Stream.iterate(1L, i -> i + 1)
                .limit(numero)
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // 19762 ms | stream faz auto box de todos os valores
    }

    private static void somaParallelStreamIterate(long numero) {
        System.out.println("Stream Parallel Sequencial");
        long result = 0;
        long init = System.currentTimeMillis();

        result = Stream.iterate(1L, i -> i + 1)
                .parallel()
                .limit(numero)
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // exception in thread "main" java.lang.OutOfMemoryError
    }
}
