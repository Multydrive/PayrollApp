package be.heh.epm.application.services;

import be.heh.epm.application.ports.in.AddEmployeeSalariedValidating;
import be.heh.epm.application.ports.in.EmployeeSalariedValidating;
import be.heh.epm.application.ports.in.AddSalariedEmployeePort;
import be.heh.epm.application.ports.out.EmployeeGateway;
import be.heh.epm.domain.*;


public class AddSalariedEmployee implements AddSalariedEmployeePort {

    private EmployeeGateway employeeGateway;

    public AddSalariedEmployee(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    public void execute (EmployeeSalariedValidating employeeSalariedValidating) {
        PaymentClassification pc = new SalariedClassification (employeeSalariedValidating.getMonthlySalary());
        PaymentSchedule ps = new MonthlyPaymentSchedule();
        PaymentMethod pm = new DirectDepositMethod("Fortis","be332211");

        Employee e = new Employee(employeeSalariedValidating.getEmpId(), employeeSalariedValidating.getName(),employeeSalariedValidating.getAddress(),
        employeeSalariedValidating.getMail());
        e.setPayClassification(pc);
        e.setPaySchedule(ps);
        e.setPayMethod(pm);

        employeeGateway.save(employeeSalariedValidating.getEmpId(), e);
    }
}