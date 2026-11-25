package com.ing.zoo.animals;

public abstract class Animal {
    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract String getHelloText();

    public void sayHello() {
        System.out.println(name + ": " + getHelloText());
    }
}
