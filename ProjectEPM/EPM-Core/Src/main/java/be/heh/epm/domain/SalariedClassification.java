package be.heh.epm.domain;
public class SalariedClassification implements PayClassification{
    private double salary;

    @Override
    public double calculatePay(double salary){
        return salary;
    }
}
