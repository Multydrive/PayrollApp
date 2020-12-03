package be.heh.epm.adapter.persistence;

import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.domain.*;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@Profile("dev")
@SpringBootTest
public class EmployeePersistenceAdapterTest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeePersistenceAdapterTest.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmployeePersistenceAdapter employeePersistenceAdapter;


    @Test
    void SalariedEmployeeSaveTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        employeePersistenceAdapter = new EmployeePersistenceAdapter(jdbcTemplate,dataSource);
        Employee salariedEmployee = new Employee("tata", "rue des Test", "toto@heh.com");
        salariedEmployee.setPayClassification(new SalariedClassification(15000));
        salariedEmployee.setPayMethod(new DirectDepositMethod("ING", "BE1825103631"));
        salariedEmployee.setPaySchedule(new MonthlyPaymentSchedule());
        Employee SavedEmployee = employeePersistenceAdapter.save(salariedEmployee);
        Assertions.assertEquals("tata", SavedEmployee.getName());
        Assertions.assertEquals("rue des Test", SavedEmployee.getAddress());
        Employee loadedEmployee = employeePersistenceAdapter.getEmployee(SavedEmployee.getEmpID());
        Assertions.assertEquals("tata", loadedEmployee.getName(), "Employee name does not match");
        Assertions.assertEquals("toto@heh.com", loadedEmployee.getMail(), "Employee mail does not match");
    }

    @Test
    void HourlyEmployeeSaveTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        employeePersistenceAdapter = new EmployeePersistenceAdapter(jdbcTemplate,dataSource);
        Employee hourlyEmployee = new Employee("tutu", "rue des Test 2", "tutu@heh.com");
        hourlyEmployee.setPayClassification(new HourlyClassification(11));
        hourlyEmployee.setPayMethod(new MailMethod(hourlyEmployee.getMail()));
        hourlyEmployee.setPaySchedule(new WeeklyPaymentSchedule());
        Employee SavedEmployee = employeePersistenceAdapter.save(hourlyEmployee);
        Assertions.assertEquals("tutu", SavedEmployee.getName());
        Assertions.assertEquals("rue des Test 2", SavedEmployee.getAddress());
        Employee loadedEmployee = employeePersistenceAdapter.getEmployee(SavedEmployee.getEmpID());
        Assertions.assertEquals("tutu", loadedEmployee.getName(), "Employee name does not match");
        Assertions.assertEquals("tutu@heh.com", loadedEmployee.getMail(), "Employee mail does not match");
    }

}