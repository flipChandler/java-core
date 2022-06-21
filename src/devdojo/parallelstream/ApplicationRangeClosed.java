package devdojo.parallelstream;

import java.util.stream.LongStream;

public class ApplicationRangeClosed {

    public static void main(String[] args) {
        long numero = 10_000_000_000L;
        somaFor(numero);
        somaRangeClosedStream(numero);
        somaRangeClosedParallelStream(numero);
        System.out.println(Runtime.getRuntime().availableProcessors()); // 8 processadores
    }

    private static void somaFor(long numero) {
        System.out.println("For");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1L; i <= numero; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // 4136 ms
    }

    private static void somaRangeClosedStream(long numero) {
        System.out.println("Range Closed Stream");
        long result = 0;
        long init = System.currentTimeMillis();

        result = LongStream.rangeClosed(1L, numero)
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // 24373 ms
    }

    private static void somaRangeClosedParallelStream(long numero) {
        System.out.println("Range Closed Parallel Stream");
        long result = 0;
        long init = System.currentTimeMillis();

        result = LongStream.rangeClosed(1L, numero)
                .parallel()
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result + " " + (end - init) + " ms");    // 1254 ms
    }
}
