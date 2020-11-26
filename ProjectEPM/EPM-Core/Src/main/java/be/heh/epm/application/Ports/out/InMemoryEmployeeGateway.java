package be.heh.epm.application.ports.out;

import be.heh.epm.database;
import be.heh.epm.domain.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

public class InMemoryEmployeeGateway implements EmployeeGateway { 

    private RelationalDataAccessApplication dbEmployee = new RelationalDataAccessApplication;

    public void save (int Id, Employee e) {

        dbEmployee.put(Id, e);
    }

    public Employee getEmployee(int id) {
        Employee e = dbEmployee.get(id);
        return e ;
    }
}