package ru.eventflow.iot.vlm.proxy.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.eventflow.iot.vlm.proxy.domain.Employee;

public interface EmployeeRepository {

    /**
     * set readOnly=true for retrieval-only methods, see for details:
     * https://stackoverflow.com/questions/10394857/how-to-use-transactional-with-spring-data#comment13524479_10466591
     */
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    Mono<Employee> findEmployeeById(String id);

    Flux<Employee> findAllEmployees();
}
