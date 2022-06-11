package devsuperior.interfaces.aula.service;

import devsuperior.interfaces.aula.interfaces.TaxService;
import devsuperior.interfaces.aula.model.CarRental;
import devsuperior.interfaces.aula.model.Invoice;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalService() {
    }

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long inicio = carRental.getStart().getTime();
        long fim = carRental.getFinish().getTime();
        double hours = (double) (fim - inicio) / 1000 / 60 / 60; // / 1000 -> de ms para segundos | / 60 -> para minutos | / 60 para hora

        double basicPayment;
        if (hours <= 12.0) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(BrazilTaxService taxService) {
        this.taxService = taxService;
    }
}
