package be.heh.epm.domain;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import static java.time.temporal.TemporalAdjusters.firstInMonth;
public class BimonthlyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(LocalDate payDate){
        
        LocalDate firstDayOfMonth = payDate.with(TemporalAdjusters.firstDayOfMonth());      
        LocalDate dateOfFirstFriday = firstDayOfMonth.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));        
        LocalDate secondFridayOfMonth = dateOfFirstFriday.plusDays(7);
        LocalDate lastFridayOfMonth = secondFridayOfMonth.plusDays(14);   
                         
        if (payDate.equals(secondFridayOfMonth) || payDate.equals(lastFridayOfMonth)) {
            return true;
        }
        else return false;
    }
}
