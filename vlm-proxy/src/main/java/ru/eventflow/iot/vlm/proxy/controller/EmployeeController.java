package ru.eventflow.iot.vlm.proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.eventflow.iot.vlm.proxy.dto.EmployeeDto;
import ru.eventflow.iot.vlm.proxy.service.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<EmployeeDto>> getEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeRepository.findEmployeeById(id).map(DomainAdapter::convert));
    }

    @GetMapping
    public ResponseEntity<Flux<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAllEmployees().map(DomainAdapter::convert));
    }
}