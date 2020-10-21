package be.heh.epm.domain;
import java.time.LocalDate;

public class PayCheck {
    @Getter
    private LocalDate date;
    @Getter
    private double salary;

    public PayCheck(LocalDate date){
        this.date = date;
    }

    public void setPay (double salary) {
        this.salary = salary;
    }

    public void setField (String field,String value) {
        field.put(field,value);
    }

    public String getField(String field) {
        return fields.get(field);
    }
}
