package be.heh.epm.domain;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
public class BimonthlyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(LocalDate payDate){
        DayOfWeek dayOfWeek = DayOfWeek.of(payDate.get(ChronoField.DAY_OF_WEEK));
        if (dayOfWeek == DayOfWeek.FRIDAY) {
            return true;
        }
        else return false;
    }
}
