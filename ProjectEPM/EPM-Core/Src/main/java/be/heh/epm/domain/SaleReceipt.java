package be.heh.epm.domain;
import lombok.Getter;

import java.time.LocalDate;

public class SaleReceipt {
    @Getter
    private LocalDate date;
    @Getter
    private double time;
    

    public SaleReceipt(LocalDate date, double time){
        this.date = date;
        this.time = time;
    }
}
