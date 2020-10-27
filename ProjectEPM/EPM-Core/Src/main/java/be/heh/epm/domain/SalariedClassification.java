package be.heh.epm.domain;
import java.time.LocalDate;
public class SalariedClassification implements PaymentClassification{
    private double salary;

    public SalariedClassification(double value){
        this.salary = value;
    }

    @Override
    public double calculatePay(LocalDate payDate){
        return salary;
    }
}
