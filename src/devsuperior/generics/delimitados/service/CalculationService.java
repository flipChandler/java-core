package devsuperior.generics.delimitados.service;

import java.util.List;

public class CalculationService {

    // has to specify that T class extends Comparable class, so the 'compareTo' is available to use
    public static <T extends Comparable<? super T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("list can't be empty");
        }

        var maxValue = list.get(0);
        for (var value : list) {
            if (value.compareTo(maxValue) > 0) {  // if value > maxValue, returns a number > 0
                maxValue = value;
            }
        }

        return maxValue;
    }
}
