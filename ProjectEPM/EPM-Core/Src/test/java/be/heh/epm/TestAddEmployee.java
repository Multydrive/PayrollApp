package be.heh.epm;

import be.heh.epm.domain.*;
import be.heh.epm.application.ports.in.*;
import be.heh.epm.application.ports.out.*;
import be.heh.epm.application.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

  
//@SpringBootTest 
public class TestAddEmployee {
    private EmployeeGateway employeeGateway;

    @Before 
    public void setUp()  {
        employeeGateway = new InMemoryEmployeeGateway();
    }
    @Test 
    public void testAddSalariedEmployee() {
        //AddEmployeeSalariedValidating addEmployeeSalariedValidating = new AddEmployeeSalariedValidating(1, "Bob", "Home", "toto@gmail.com", 1500);
        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(employeeGateway);
        EmployeeSalariedValidating employeeSalariedValidating = new EmployeeSalariedValidating();

        employeeSalariedValidating.setEmpId(1);
        employeeSalariedValidating.setName("toto");
        employeeSalariedValidating.setAddress("rue de Mons");
        employeeSalariedValidating.setMail("toto@heh.be");
        employeeSalariedValidating.setMonthlySalary(1500);
        addSalariedEmployee.execute(employeeSalariedValidating);

        Employee e = employeeGateway.getEmployee(employeeSalariedValidating.getEmpId());
        assertEquals("toto", e.getName());
        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);
        PaymentMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis : be332211", pm.toString());
    } 
}