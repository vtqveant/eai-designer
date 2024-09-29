package ru.eventflow.iot.vlm.proxy.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

public interface EmployeeRepository {

    Mono<Employee> findEmployeeById(String id);

    Flux<Employee> findAllEmployees();
}
