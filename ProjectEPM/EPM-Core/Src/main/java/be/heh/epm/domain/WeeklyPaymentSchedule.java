package be.heh.epm.domain;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
public class WeeklyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(){
        DayOfWeek dayOfWeek = DayOfWeek.of(LocalDate.now().get(ChronoField.DAY_OF_WEEK));
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            return true;
        }
        else return false;
    }
}
