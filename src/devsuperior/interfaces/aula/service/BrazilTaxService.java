package devsuperior.interfaces.aula.service;

import devsuperior.interfaces.aula.interfaces.TaxService;

public class BrazilTaxService implements TaxService {

    @Override
    public double tax(double amount) {
        if (amount <= 100.0) {
            return amount * 0.2;
        }
        return amount * 0.15;
    }
}
