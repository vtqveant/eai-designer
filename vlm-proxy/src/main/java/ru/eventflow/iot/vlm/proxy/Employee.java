package ru.eventflow.iot.vlm.proxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Employee {

    @JsonProperty
    private final String id;

    @JsonProperty
    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
