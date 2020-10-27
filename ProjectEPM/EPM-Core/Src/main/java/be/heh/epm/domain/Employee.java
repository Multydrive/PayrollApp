package be.heh.epm.domain;

import java.time.LocalDate;

public class Employee {

    private PaymentClassification pay;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    private PayCheck check;
    private int id;
    private String name;
    private String address;
    private String mail;
    
    public Employee(int id, String name, String address, String mail){
        this.id = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
    }
    public void setPayClassification(PaymentClassification calcul){
        this.pay = calcul;
    }

    public void setPaySchedule(PaymentSchedule daySchedule){
        this.schedule = daySchedule;
    }

    public void setPayMethod(PaymentMethod choiceMethod) {
        this.method = choiceMethod;
    }

    public void payDay(PayCheck verification) {
        this.check = verification;
        check.setPay(this.pay.calculatePay(check.getDate()));
    }

    public PaymentSchedule getPaySchedule() {
        return this.schedule;
    }

    public PaymentMethod getPayMethod() {
        return this.method;
    }

    public String getMail() {
        return this.mail;
    }
    public PaymentClassification getPayClassification(){
        return this.pay;
    }

    public boolean isDatePay(LocalDate datePay){
        return schedule.paymentDate(datePay);
    }
}










