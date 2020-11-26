package be.heh.epm.adapter.web;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface EmployeeRepository extends JpaRepository<EmployeeSalariedValidating, Integer> {

}
