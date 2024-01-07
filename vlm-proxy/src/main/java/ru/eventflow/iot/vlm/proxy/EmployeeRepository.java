package ru.eventflow.iot.vlm.proxy;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeRepository {

    public Mono<Employee> findEmployeeById(String id) {
        return Mono.just(new Employee(id, "test"));
    }

    public Flux<Employee> findAllEmployees() {
        return Flux.just(new Employee("XXX", "test"));
    }
}
