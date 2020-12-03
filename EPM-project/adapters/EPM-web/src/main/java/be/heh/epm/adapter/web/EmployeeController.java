package be.heh.epm.adapter.web;

import be.heh.epm.application.port.in.AddHourlyEmployeeUseCase;
import be.heh.epm.application.port.in.EmployeeHourlyValidating;
import be.heh.epm.application.port.in.EmployeeSalariedValidating;
import be.heh.epm.application.port.in.AddSalariedEmployeeUseCase;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.application.service.AddSalariedEmployeeService;
import be.heh.epm.common.WebAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@WebAdapter
@RestController
public class EmployeeController {

    private AddSalariedEmployeeUseCase addSalariedEmployee;
    private AddHourlyEmployeeUseCase addHourlyEmployee;

    public EmployeeController(AddSalariedEmployeeUseCase addSalariedEmployee, AddHourlyEmployeeUseCase addHourlyEmployee){
        this.addSalariedEmployee = addSalariedEmployee;
        this.addHourlyEmployee = addHourlyEmployee;
    }

    @CrossOrigin
    @PostMapping("/employees/salaried")
    ResponseEntity<Void> newEmployee(@Valid @RequestBody EmployeeSalariedValidating newEmployee) {


        addSalariedEmployee.execute(newEmployee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getEmpId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @CrossOrigin
    @PostMapping("/employees/hourly")
    ResponseEntity<Void> newEmployee(@Valid @RequestBody EmployeeHourlyValidating newEmployee) {


        addHourlyEmployee.execute(newEmployee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newEmployee.getEmpId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
