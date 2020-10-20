package be.heh.epm.domain;
import java.time.LocalDate;
import static java.time.Month.*;
import java.time.temporal.TemporalAdjusters;

public class MonthlyPaymentSchedule implements PaymentSchedule{
    public LocalDate paymentDate(){
        LocalDate lastDayofCurrentMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return lastDayofCurrentMonth;
    }
}
