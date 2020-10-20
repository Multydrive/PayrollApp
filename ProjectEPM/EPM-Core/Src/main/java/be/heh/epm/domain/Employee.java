package be.heh.epm.domain;
public class Employee {

    private PayClassification pay;
    private PaymentSchedule schedule;
    private int id;
    private String name;
    private String address;

    public Employee(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setPayClassification(PayClassification calcul){
        this.pay = calcul;
    }

    public void setPaymentSchedule(PaymentSchedule daySchedule){
        this.schedule = daySchedule;
    }
    
}
