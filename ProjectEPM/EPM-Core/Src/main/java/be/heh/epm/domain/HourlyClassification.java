package be.heh.epm.domain;
public class HourlyClassification implements PaymentClassification{
    private double salary;
    @Override
    public double calculatePay(){
        return salary;
    }
}
