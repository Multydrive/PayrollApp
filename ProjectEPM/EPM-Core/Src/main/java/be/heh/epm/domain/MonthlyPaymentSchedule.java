package be.heh.epm.domain;
import java.time.LocalDate;
import static java.time.Month.*;
import java.time.temporal.TemporalAdjusters;

public class MonthlyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(){
        LocalDate lastDayofCurrentMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        if (LocalDate.now() == lastDayofCurrentMonth) {
            return true;
        }
        else return false;
    }
}
