package com.fiipractic.health.model;

public class Doctor {
    private Long id;
    private String name;
    private String function;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
