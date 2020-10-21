package be.heh.epm.domain;
public class SalariedClassification implements PayClassification{
    private double salary;

    public SalariedClassification(double value){
        this.salary = value;
    }

    @Override
    public double calculatePay(double salary){
        return salary;
    }
}
