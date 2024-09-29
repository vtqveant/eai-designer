package ru.eventflow.iot.vlm.proxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.eventflow.iot.vlm.proxy.dao.EmployeeDao;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

@Component
public class PostgresEmployeeRepository implements EmployeeRepository {

    private final EmployeeDao employeeDao;

    @Autowired
    public PostgresEmployeeRepository(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Mono<Employee> findEmployeeById(String id) {
        return Mono.justOrEmpty(employeeDao.findEmployeeById(Integer.parseInt(id)));
    }

    @Override
    public Flux<Employee> findAllEmployees() {
        return Flux.fromIterable(employeeDao.findAllEmployees());
    }
}
