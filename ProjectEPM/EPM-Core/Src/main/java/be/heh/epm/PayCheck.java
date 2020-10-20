package be.heh.epm.domain;
import java.time.LocalDate;

public class PayCheck {
    
    private LocalDate date;
    private LocalDate getDate () {
        return this.date;
    }

    private double salary;
    private double getSalary () {
        return this.salary;
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
