package be.heh.entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TestEmployee {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee(100,"toto","av maistriau");
    }

    @Test
    public void createSalariedEmployee() {

        employee.setPayClassification(new SalariedClassification(1000));
        employee.setPayMethod(new DirectDepositMethod("ING","be80-4444-444"));
        employee.setPaySchedule(new MonthlyPaymentySchedule());

        assertEquals(1000.0,employee.calculatePay(),0.01);

        PaymentSchedule ps = employee.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentySchedule);

        PaymentMethod pm = employee.getPayMethod();
        assertEquals("direct deposit into ING : be80-4444-444",pm.toString());

    }

    @Test
    public void createHourlyEmployee() {

        employee.setPayClassification(new HourlyClassification(20.0));
        employee.setPayMethod(new MailMethod("toto@gmail.com"));
        employee.setPaySchedule(new WeeklyPaymentSchedule());

        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);
        PaymentClassification classification= employee.getPayClassification();
        ((HourlyClassification)classification).addTimeCard(new TimeCard(date, 8.0));
        ((HourlyClassification)classification).addTimeCard(new TimeCard(nextDate, 10.0));

        assertEquals(380.0,employee.calculatePay(),0.01);

        PaymentSchedule ps = employee.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = employee.getPayMethod();
        assertEquals("mail : toto@gmail.com",pm.toString());

    }


}
