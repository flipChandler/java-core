package devsuperior.interfaces.methoddefault;

public class UsaInterestService implements InterestService {

    private double taxRate;

    public UsaInterestService(double taxRate) {
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
