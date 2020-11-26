package be.heh.epm.adaptater.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
public class TestDatabase {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private EmployeeSalariedValidating employee;

    @Test
    public void TestInsert (){
        InsertDataBase insert = new InsertDataBase(jdbcTemplate,dataSource);
        employee = new EmployeeSalariedValidating();
        employee.setName("test");
        employee.setAddress("ttt");
        employee.setMail("rerer");
        employee.setEmployeeClassification("salaried");
        employee.setMonthlySalary(1700);
        insert.save(employee);
        insert.saveSalaried(employee);
    }
}
