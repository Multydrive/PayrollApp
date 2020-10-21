package be.heh.epm.domain;
public class Employee {

    private PayClassification pay;
    private PaymentSchedule schedule;
    private PayMethod method;
    private PayCheck check;
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

    public void setPaySchedule(PaymentSchedule daySchedule){
        this.schedule = daySchedule;
    }

    public void setPayMethod(PayMethod choiceMethod) {
        this.method = choiceMethod;
    }

    public void payday(PayCheck verification) {
        this.check = verification;
    }

    public PaymentSchedule getPaySchedule() {
        return this.schedule;
    }

    public PaymentMethod getPayMethod() {
        return this.method;
    }

}
