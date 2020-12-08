package be.heh.epm.domain;
import lombok.Getter;

import java.time.LocalDate;

public class SaleReceipt {
    @Getter
    private LocalDate date;
    @Getter
    private double sale;
    

    public SaleReceipt(LocalDate date, double sale){
        this.date = date;
        this.sale = sale;
    }
}
