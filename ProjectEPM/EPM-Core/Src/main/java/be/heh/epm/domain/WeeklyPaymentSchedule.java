package be.heh.epm.domain;
public class WeeklyPaymentSchedule implements PaymentSchedule{
    @Override
    public boolean paymentDate(){
        return true;
    }
}
