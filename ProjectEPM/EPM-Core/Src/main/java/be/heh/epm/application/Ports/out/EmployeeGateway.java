package be.heh.epm.application.ports.out;

import be.heh.epm.domain.*;
import lombok.Getter;
import lombok.Setter;

public interface EmployeeGateway {   
    public void save (int Id, Employee e);
    public Employee getEmployee(int id);

}
