package be.heh.epm.adapter.persistence;

import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.PersistenceAdapter;
import be.heh.epm.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@PersistenceAdapter
public class EmployeePersistenceAdapter implements EmployeePort {

    private static final Logger logger = LoggerFactory.getLogger(EmployeePersistenceAdapter.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsertEmployee;
    private final SimpleJdbcInsert simpleJdbcInsertPaymentMethod;
    private final SimpleJdbcInsert simpleJdbcInsertSalariedClassification;
    private final SimpleJdbcInsert simpleJdbcInsertHourlyClassification;
    private final SimpleJdbcInsert simpleJdbcInsertCommissionClassification;
    private final DataSource dataSource;

    public EmployeePersistenceAdapter(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
        this.simpleJdbcInsertEmployee = new SimpleJdbcInsert(dataSource).withTableName("employee").usingGeneratedKeyColumns("id");
        this.simpleJdbcInsertPaymentMethod = new SimpleJdbcInsert(dataSource).withTableName("directdepositmethod");
        this.simpleJdbcInsertSalariedClassification = new SimpleJdbcInsert(dataSource).withTableName("salariedclassification");
        this.simpleJdbcInsertHourlyClassification = new SimpleJdbcInsert(dataSource).withTableName("hourlyclassification");
        this.simpleJdbcInsertCommissionClassification = new SimpleJdbcInsert(dataSource).withTableName("commissionclassification");
    }

    @Override
    public Employee getEmployee(int empID) {
        try {
            Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",
                    new Object[]{empID},
                    (rs, rowNum) -> {
                        Employee e = new Employee();
                        e.setEmpID(rs.getInt("id"));
                        e.setName(rs.getString("surname"));
                        e.setAddress(rs.getString("address"));
                        e.setMail(rs.getString("mail"));
                        return e;
                    });
            logger.info("Recovery of the employee by id {} in the database",empID);
            return employee;
        } catch (EmptyResultDataAccessException e) {
            logger.error("Employee with id {} was not found",empID);
            return null;
        }
    }

    @Override
    public Employee save(Employee employee) {
        Map<String, Object> parameters = new HashMap<>(1);
        parameters.put("payment_method",employee.getPayMethod().toString());
        parameters.put("payment_schedule",employee.getPaySchedule().toString());
        parameters.put("employee_classification",employee.getPayClassification().toString());
        parameters.put("surname", employee.getName());
        parameters.put("firstname", employee.getName());
        parameters.put("address", employee.getAddress());
        parameters.put("mail", employee.getMail());

        // Execute the query and get the generated key
        Number newId = simpleJdbcInsertEmployee.executeAndReturnKey(parameters);
        logger.info("Inserting salaried employee into database, generated key is: {}", newId);
        employee.setEmpID((Integer) newId);

        if(employee.getPayClassification().toString()=="salaried"){
            Map<String, Object> parametersSalariedClassification = new HashMap<>(1);
            parametersSalariedClassification.put("id", employee.getEmpID());
            SalariedClassification salariedClassification = (SalariedClassification)employee.getPayClassification();
            parametersSalariedClassification.put("salary", salariedClassification.getSalary());
            simpleJdbcInsertSalariedClassification.execute(parametersSalariedClassification);
        }

        else if (employee.getPayClassification().toString()=="hourly")  {
            Map<String, Object> parametersHourlyClassification = new HashMap<>(1);
            parametersHourlyClassification.put("id", employee.getEmpID());
            HourlyClassification hourlyClassification = (HourlyClassification)employee.getPayClassification();
            parametersHourlyClassification.put("rate", hourlyClassification.getHourlyRate());
            simpleJdbcInsertHourlyClassification.execute(parametersHourlyClassification);
        }

        else {
            Map<String, Object> parametersCommissionClassification = new HashMap<>(1);
            parametersCommissionClassification.put("id", employee.getEmpID());
            CommissionClassification commissionclassification = (CommissionClassification)employee.getPayClassification();
            parametersCommissionClassification.put("salary", commissionclassification.getAmount());
            parametersCommissionClassification.put("commission", commissionclassification.getCommission_rate());
            simpleJdbcInsertCommissionClassification.execute(parametersCommissionClassification);
        }

        if (employee.getPayMethod().toString()=="direct") {
            Map<String, Object> parametersDirectDepositMethod = new HashMap<>(1);
            parametersDirectDepositMethod.put("id", employee.getEmpID());
            DirectDepositMethod directDeposit = (DirectDepositMethod)employee.getPayMethod();
            parametersDirectDepositMethod.put("bank", directDeposit.getBank());
            parametersDirectDepositMethod.put("num_account", directDeposit.getAccountNumber());

            simpleJdbcInsertPaymentMethod.execute(parametersDirectDepositMethod);
        }

        return employee;
    }

    @Override
    public void deleteEmployee(int empID) {

    }

    @Override
    public ArrayList<Employee> getAllEmployee() {
        return null;
    }
}