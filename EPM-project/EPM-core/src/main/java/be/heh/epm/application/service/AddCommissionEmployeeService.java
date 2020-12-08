package be.heh.epm.application.service;

import be.heh.epm.application.port.in.AddCommissionEmployeeUseCase;
import be.heh.epm.application.port.in.EmployeeCommissionValidating;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.UseCase;
import be.heh.epm.domain.*;

@UseCase
public class AddCommissionEmployeeService implements AddCommissionEmployeeUseCase {

    private EmployeePort employeePort;

    public AddCommissionEmployeeService(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void execute(EmployeeCommissionValidating employeeCommissionValidating) {
        PaymentClassification pc = new CommissionClassification(employeeCommissionValidating.getMonthlySalary(),employeeCommissionValidating.getCommission_rate());
        PaymentSchedule ps = new BimonthlyPaymentSchedule();
        PaymentMethod pm = new DirectDepositMethod(employeeCommissionValidating.getBank(),employeeCommissionValidating.getAccount());

        Employee e = new Employee(employeeCommissionValidating.getName(),employeeCommissionValidating.getAddress(),employeeCommissionValidating.getMail());
        e.setPayClassification(pc);
        e.setPaySchedule(ps);
        e.setPayMethod(pm);

        Employee employee = employeePort.save(e);

    }

}

