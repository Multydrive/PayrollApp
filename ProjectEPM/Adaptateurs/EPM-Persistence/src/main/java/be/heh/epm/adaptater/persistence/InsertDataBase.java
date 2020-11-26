package be.heh.epm.database;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class InsertDataBase {
    //DriverManagerDataSource dataSource = new DriverManagerDataSource();
    DataSource dataSource;
    SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("EMPLOYEE");

    public int addEmployee(EmployeeSalariedValidating emp) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ID", emp.getId());
        parameters.put("FIRST_NAME", emp.getName());
        parameters.put("LAST_NAME", "test");
        parameters.put("ADDRESS", emp.getAddress());
        parameters.put("SALARY", emp.getMonthlySalary());


        return simpleJdbcInsert.execute(parameters);
    }
}