package devsuperior.interfaces.methoddefault;

import java.security.InvalidParameterException;
import java.util.Optional;

public interface InterestService {

    double getTaxRate();

    default double payment(double amount, int months) {

        return Optional.ofNullable(months)
                .filter(month -> month > 1)
                .map(month -> amount * Math.pow(1.0 + getTaxRate() / 100.0, month))
                .orElseThrow(() -> new InvalidParameterException("Months must be greater than zero"));
    }
}
