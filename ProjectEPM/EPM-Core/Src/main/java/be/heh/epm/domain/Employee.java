package be.heh.epm.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;

public class Employee {

    private PaymentClassification pay;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    private PayCheck check;
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String address;
    @Getter
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
  
    public PaymentClassification getPayClassification(){
        return this.pay;
    }

    public boolean isDatePay(LocalDate datePay){
        boolean anwser = schedule.paymentDate(datePay);
        return anwser;      
    }

}










