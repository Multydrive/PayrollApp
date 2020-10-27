package be.heh.epm.domain;

import java.time.LocalDate;

public interface PaymentClassification {
    public abstract double calculatePay(LocalDate payDate);
}
