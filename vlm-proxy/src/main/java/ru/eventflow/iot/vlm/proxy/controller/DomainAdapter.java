package ru.eventflow.iot.vlm.proxy.controller;

import ru.eventflow.iot.vlm.proxy.domain.Employee;
import ru.eventflow.iot.vlm.proxy.dto.EmployeeDto;

/**
 * DTO to domain model conversion and vice versa
 */
public class DomainAdapter {

    public static Employee convert(EmployeeDto dto) {
        return new Employee(dto.getId(), dto.getName());
    }

    public static EmployeeDto convert(Employee model) {
        return new EmployeeDto(model.getId(), model.getName());
    }

}
