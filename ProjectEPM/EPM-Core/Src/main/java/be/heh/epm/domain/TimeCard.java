package be.heh.epm.domain;
import lombok.Getter;

import java.time.LocalDate;

public class TimeCard {
    @Getter
    private LocalDate date;
    @Getter
    private double time;
    

    public TimeCard(LocalDate date, double time){
        this.date = date;
        this.time = time;
    }
}
