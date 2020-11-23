package be.heh.epm.application.ports.in;

import be.heh.epm.domain.*;
import lombok.Getter;
import lombok.Setter;

public class EmployeeSalariedValidating {
    @Getter @Setter  
    private int empId = 100 ;
    @Getter @Setter
    private String name = "toto";
    @Getter @Setter
    private String address = "av maistriau";
    @Getter @Setter
    private String mail = "toto@heh.be";
    @Getter @Setter
    private double monthlySalary = 1500;

    public EmployeeSalariedValidating (){

    }

    public EmployeeSalariedValidating (int empId, String name, String address, String mail, int monthlySalary){
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.monthlySalary = monthlySalary;
    }
}