package be.heh.epm.domain;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashMap;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;
import java.util.Map;

public class CommissionClassification implements PaymentClassification{
    private Map<LocalDate, TimeCard> pointers = new HashMap<LocalDate, TimeCard>();
    private TimeCard c;
    private double salary;
    @Setter
    private double amount;
    public CommissionClassification(double hours){
        this.amount = hours;
    }
    @Override
    public double calculatePay(LocalDate payDate){
        LocalDate dt = payDate;
        dt = dt.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        
        Iterator iterator = pointers.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
            TimeCard tps =pointers.get(mapentry.getKey());
            if( tps.getDate().isAfter(dt)){
                
                TimeCard h =pointers.get(mapentry.getKey());
                if(h.getTime()<8){
                    this.salary+=h.getTime()*amount;
                }
                else{
                    this.salary+=(8*amount)+(((h.getTime()-8)*1.5)*amount);
                }
            }
        }
        return salary;
    }
    public void addTimeCard(TimeCard tc){
        this.c = tc;
        
        setPointers(tc.getDate(), tc);
    }
    public void setPointers(LocalDate dateP, TimeCard value) {
        pointers.put(dateP, value);
    }

}
