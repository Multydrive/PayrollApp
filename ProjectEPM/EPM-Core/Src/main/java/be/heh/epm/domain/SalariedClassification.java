package be.heh.epm.domain;
public class SalariedClassification implements PaymentClassification{
    private double salary;

    public SalariedClassification(double value){
        this.salary = value;
    }

    @Override
    public double calculatePay(){
        return salary;
    }
}
