package be.heh.epm.domain;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
public class BimonthlyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(LocalDate payDate){
        LocalDate firstDayOfMonth = payDate.with(TemporalAdjusters.firstDayOfMonth());      
        LocalDate dateOfFirstFriday = payDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));
        LocalDate secondFridayOfMonth = dateOfFirstFriday.plusDays(7);
        LocalDate lastFridayOfMonth = secondFridayOfMonth.plusDays(14);    
        if (payDate == firstDayOfMonth) {
            return true;
        }
        else return false;
    }
}
