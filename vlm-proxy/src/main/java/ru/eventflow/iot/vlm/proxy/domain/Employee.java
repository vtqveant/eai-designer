package ru.eventflow.iot.vlm.proxy.domain;

import lombok.Getter;

@Getter
public class Employee {

    private final String id;

    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
