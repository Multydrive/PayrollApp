package be.heh.epm.adapter.web;

import be.heh.epm.application.ports.in.AddEmployeeSalariedValidating;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  private final EmployeeModelAssembler assembler;

  EmployeeController(EmployeeRepository repository,EmployeeModelAssembler assembler) {

    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/employees")
  List<EmployeeSalariedValidating> all() {
    return repository.findAll();
  }

  @PostMapping("/employees/salaried")
  ResponseEntity<Void> newEmployee(@RequestBody EmployeeSalariedValidating newEmployee) {
    EmployeePort employeePort = mock(EmployeePort.class);
    AddEmployeeSalariedValidating


    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newEmployee.getId())
            .toUri();
    return ResponseEntity.created(location).build();

  }


  @GetMapping("/employees/salaried/{id}")
  EmployeeSalariedValidating one(@PathVariable int id) {

    return (EmployeeSalariedValidating) repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));

  }

}