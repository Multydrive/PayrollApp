package be.heh.epm.domain;

import java.time.LocalDate;

public interface PaymentSchedule {
    public abstract boolean paymentDate(LocalDate datePay);
}
