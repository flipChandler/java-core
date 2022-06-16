package devsuperior.functionallambda.comparator;

import java.util.List;

public class ApplicationReduce {

    public static void main(String[] args) {
        var list = List.of(10, 20, 34, 11, 45);
        var sum = 0;
        for (var value : list) {
            sum += value;
        }
        System.out.println(sum);

        // expressividade / conciso
        var soma = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(soma);
    }
}
