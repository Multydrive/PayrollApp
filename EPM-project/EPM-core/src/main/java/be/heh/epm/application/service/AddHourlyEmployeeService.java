package be.heh.epm.application.service;

import be.heh.epm.application.port.in.AddHourlyEmployeeUseCase;
import be.heh.epm.application.port.in.EmployeeHourlyValidating;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.UseCase;
import be.heh.epm.domain.*;

@UseCase
public class AddHourlyEmployeeService implements AddHourlyEmployeeUseCase {

    private EmployeePort employeePort;

    public AddHourlyEmployeeService(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void execute(EmployeeHourlyValidating employeeHourlyValidating) {
        PaymentClassification pc = new HourlyClassification(employeeHourlyValidating.getRate());
        PaymentSchedule ps = new WeeklyPaymentSchedule();
        PaymentMethod pm = new DirectDepositMethod(employeeHourlyValidating.getBank(),employeeHourlyValidating.getAccount());

        Employee e = new Employee(employeeHourlyValidating.getName(),employeeHourlyValidating.getAddress(),employeeHourlyValidating.getMail());
        e.setPayClassification(pc);
        e.setPaySchedule(ps);
        e.setPayMethod(pm);

        Employee employee = employeePort.save(e);

    }

}
