package be.heh.epm.domain;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashMap;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Iterator;
import java.util.Map;

public class CommissionClassification implements PaymentClassification{

    private Map<LocalDate, SaleReceipt> receipt = new HashMap<LocalDate, SaleReceipt>();
    private SaleReceipt s;
    @Getter
    private double commission;
    @Getter
    @Setter
    private double amount;
    @Getter
    @Setter
    private double commission_rate;

    public CommissionClassification(double sale, double commission_rate){
        this.amount = sale;
        this.commission_rate = commission_rate;
    }

    @Override
    public double calculatePay(PayCheck paycheck){
        LocalDate dt = paycheck.getDate();
        dt = dt.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        
        Iterator iterator = receipt.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
            SaleReceipt tps = receipt.get(mapentry.getKey());
            if( tps.getDate().isAfter(dt)){              
                SaleReceipt h =receipt.get(mapentry.getKey());           
                this.commission+=h.getSale()*commission_rate;
            }
        }
        double salary = commission + amount;
        return salary;
    }
    public void addSaleReceipt(SaleReceipt sr){
        this.s = sr;
        
        setPointers(sr.getDate(), sr);
    }
    public void setPointers(LocalDate dateP, SaleReceipt sale) {
        receipt.put(dateP, sale);
    }

    @Override
    public String toString(){
        return "commission";
    }

}
