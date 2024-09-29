package ru.eventflow.iot.vlm.proxy.service;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

@Component
public class MockEmployeeRepository implements EmployeeRepository {

    @Override
    public Mono<Employee> findEmployeeById(String id) {
        return Mono.just(new Employee(id, "test"));
    }

    @Override
    public Flux<Employee> findAllEmployees() {
        return Flux.just(new Employee("XXX", "test"));
    }

}
