package devsuperior.interfaces.exe.interfaces.service;

import devsuperior.interfaces.exe.interfaces.interfaces.OnlinePaymentService;
import devsuperior.interfaces.exe.interfaces.model.Contract;
import devsuperior.interfaces.exe.interfaces.model.Installment;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONTH;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void process(Contract contract, Integer months) {
        var basicQuota = contract.getTotalValue() / months;

        for (var index = 1; index < months + 1; index++) {
            var updatedQuota = basicQuota + paymentService.interest(basicQuota, index);
            var fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
            var dueDate = addMonths(contract.getDate(), index);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }

    private Date addMonths(Date date, int numero) {
        var installmentMonth = Calendar.getInstance();
        installmentMonth.setTime(date);
        installmentMonth.add(MONTH, numero);
        return installmentMonth.getTime();
    }
}
