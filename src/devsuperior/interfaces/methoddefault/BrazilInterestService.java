package devsuperior.interfaces.methoddefault;

public class BrazilInterestService implements InterestService {

    private double taxRate;

    public BrazilInterestService(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
