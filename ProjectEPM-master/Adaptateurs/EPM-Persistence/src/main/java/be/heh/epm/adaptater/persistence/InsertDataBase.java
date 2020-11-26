package be.heh.epm.adaptater.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class InsertDataBase {
    private DataSource dataSource;
    private SimpleJdbcInsert simpleJdbcInsert ;
    private SimpleJdbcInsert simpleJdbcInsertSalaried ;
    private JdbcTemplate jdbcTemplate;

    public InsertDataBase (JdbcTemplate jdbcTemplate, DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate ;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("EMPLOYEE").usingGeneratedKeyColumns("ID");
        simpleJdbcInsertSalaried = new SimpleJdbcInsert(dataSource).withTableName("SALARIED_CLASSIFICATION");
    }

    public int save(EmployeeSalariedValidating emp) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("FIRSTNAME", emp.getName());
        parameters.put("SURNAME", "test");
        parameters.put("PAYMENT_METHOD", "direct deposit" );
        parameters.put("EMPLOYEECLASSIFICATION", emp.getEmployeeClassification() );
        parameters.put("ADDRESS", emp.getAddress());
        parameters.put("MAIL", emp.getMail());

        return simpleJdbcInsert.execute(parameters);
    }

    public int getLastEmployee() {
        return  jdbcTemplate.queryForObject("SELECT MAX(ID) FROM EMPLOYEE",new Object[]{}, Integer.class);
    }

    public int saveSalaried (EmployeeSalariedValidating emp){

        if (emp.getEmployeeClassification().equals("salaried")) {
            int empId = getLastEmployee();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("EMPLOYEE_ID",empId);
            parameters.put("SALARY", emp.getMonthlySalary());

            return simpleJdbcInsertSalaried.execute(parameters);
        }
        else {
            return 0;
        }
    }
}